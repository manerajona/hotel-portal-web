package ar.edu.iua.portal.hotel.validator;

import ar.edu.iua.portal.hotel.cons.Imessages;
import ar.edu.iua.portal.hotel.dao.ReservationDao;
import ar.edu.iua.portal.hotel.entity.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

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

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "fieldName", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "checkIn", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "checkOut", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "guests", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "idUser", "NotEmpty");

        if (reservation.getCheckIn().before(reservation.getCheckOut())) {
            errors.rejectValue("checkIn", Imessages.CHECK_IN_MUST_BE_BEFORE_CHECK_OUT);
        }
        if(reservation.getGuests() > 0){
            errors.rejectValue("guests", Imessages.GUESTS_MUST_BE_GREATER_THAN_ZERO);
        }
    }
}
