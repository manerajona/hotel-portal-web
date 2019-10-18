package ar.edu.iua.portal.hotel.dao;

import ar.edu.iua.portal.hotel.entity.Reservation;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

public interface ReservationDao {

    Reservation findById(Long id);

    List<Reservation> getAllReservations();

    Reservation updateReservation(Long id, Date checkIn, Date checkOut, Integer guests, String roomType);

    Reservation createOrUpdateReservation(Reservation reservation);

    void deleteReservationById(Long id);
}