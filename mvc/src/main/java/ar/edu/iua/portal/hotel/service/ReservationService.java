package ar.edu.iua.portal.hotel.service;

import ar.edu.iua.portal.hotel.entity.Reservation;

import java.sql.Date;
import java.util.List;

public interface ReservationService {

    void save(Reservation reservation);

    List<Reservation> findAllReservations();

    void deleteReservation(Long id);

    Reservation updateReservation(Long id, Date newCheckIn, Date newCheckOut, Integer newGuests, String newRoomType);
}
