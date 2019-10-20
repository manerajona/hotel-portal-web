package ar.edu.iua.portal.hotel.service.impl;

import ar.edu.iua.portal.hotel.dao.ReservationDao;
import ar.edu.iua.portal.hotel.entity.Reservation;
import ar.edu.iua.portal.hotel.service.ReservationService;
import ar.edu.iua.portal.hotel.validator.ReservationValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import java.util.List;
import java.util.Locale;

@Service
@Qualifier("messageServiceImpl")
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    @Qualifier("reservationDaoImpl")
    private ReservationDao reservationDao;

    @Autowired
    private ReservationValidator reservationValidator;

    @Override
    public boolean createOrUpdate(Reservation reservation,
                     String username,
                     BindingResult bindingResult,
                     Model model,
                     MessageSource messageSource) {

        reservation.setUsername(username);

        reservationValidator.validate(reservation, bindingResult);

        if (!bindingResult.hasErrors()) {
            reservationDao.createOrUpdateReservation(reservation);
            model.addAttribute("css", "success");
            model.addAttribute("message", messageSource.getMessage("Success.Reservation", null, Locale.getDefault()));
            model.addAttribute("reservationForm", new Reservation());
            return false;
        }
        return true;
    }

    @Override
    public List<Reservation> findAllReservations() {
        return reservationDao.getAllReservations();
    }

    @Override
    public Reservation findById(Long id) {
        return reservationDao.findById(id);
    }

    @Override
    public void deleteReservation(Long id) {
        reservationDao.deleteReservationById(id);
    }

}
