package ar.edu.iua.portal.hotel.dao;

import ar.edu.iua.portal.hotel.entity.Reservation;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

public interface ReservationDao {

    List<Reservation> getUserReservations(String username);

    List<Reservation> getAllReservations();

    Reservation updateReservation(Long id, Date newCheckIn, Date newCheckOut, Integer newGuests, String roomType);

    Reservation createReservation(Reservation reservation);

}