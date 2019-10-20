package ar.edu.iua.portal.hotel.service;

import ar.edu.iua.portal.hotel.entity.Reservation;
import org.springframework.validation.BindingResult;

import java.util.List;

public interface ReservationService {

    boolean createOrUpdate(Reservation reservation, String username, BindingResult bindingResult);

    List<Reservation> findAllReservations();

    Reservation findById(Long id);

    void deleteReservation(Long id);

    List<Reservation> findReservationsByUsername(String username);
    
}
