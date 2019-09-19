package ar.edu.iua.portal.hotel.dao;

import ar.edu.iua.portal.hotel.entity.Reservation;

import java.sql.Timestamp;
import java.util.List;

public interface ReservationDao {

    List<Reservation> getUserReservations(String username);

    List<Reservation> getAllReservations();

    Reservation updateReservation(Long id, Timestamp newCheckIn, Timestamp newCheckOut, Integer newGuests);

    Reservation createReservation(Reservation reservation);

}