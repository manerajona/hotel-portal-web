package ar.edu.iua.portal.hotel.service;

import ar.edu.iua.portal.hotel.entity.Reservation;
import org.springframework.context.MessageSource;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import java.sql.Date;
import java.util.List;

public interface ReservationService {

    boolean createOrUpdate(Reservation reservation,
              String username,
              BindingResult bindingResult,
              Model model,
              MessageSource messageSource);

    List<Reservation> findAllReservations();

    Reservation findById(Long id);

    void deleteReservation(Long id);
    
}
