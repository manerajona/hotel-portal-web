package ar.edu.iua.portal.hotel.services;

import ar.edu.iua.portal.hotel.model.entities.Reservation;
import org.springframework.validation.BindingResult;

import java.sql.Date;
import java.util.List;

public interface ReservationService {

    boolean createOrUpdate(Reservation reservation, String username, BindingResult bindingResult);

    List<Reservation> findAllReservations();

    Reservation findById(Long id);

    void deleteReservation(Long id);

    List<Reservation> findReservationsByUsername(String username);

    List<Reservation> findByCheckInAndCheckOutAndRoomType(Date checkIn, Date checkOut, String roomType);
    
}
