package ar.edu.iua.portal.hotel.validator;

import ar.edu.iua.portal.hotel.dao.ReservationDao;
import ar.edu.iua.portal.hotel.entity.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.sql.Date;

import static ar.edu.iua.portal.hotel.cons.Imessages.*;

@Component
public class ReservationValidator implements Validator {

    @Autowired
    private ReservationDao reservationDao;

    @Override
    public boolean supports(Class<?> aClass) {
        return Reservation.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Reservation reservation = (Reservation) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "checkIn", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "checkOut", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "guests", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "roomType", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty");

        if (reservation.getCheckIn().after(reservation.getCheckOut())) {
            errors.rejectValue("checkIn", "checkIn.incorrect", CHECK_IN_MUST_BE_BEFORE_CHECK_OUT);
        }
        if (reservation.getCheckIn().before(new Date(System.currentTimeMillis()))) {
            errors.rejectValue("checkIn", "checkIn.incorrect", CHECK_IN_MUST_BE_BEFORE_TODAY);
        }
        if (reservation.getGuests() < 1) {
            errors.rejectValue("guests", "guests.incorrect", GUESTS_MUST_BE_GREATER_THAN_ZERO);
        }
    }
}
