package ar.edu.iua.portal.hotel.validator;

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

        // TODO validations for reservation
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "fieldName", "NotEmpty");
        if (false) {
            errors.rejectValue("fieldName", "something");
        }
    }
}
