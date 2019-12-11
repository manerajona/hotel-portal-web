package ar.edu.iua.portal.hotel.dao;

import ar.edu.iua.portal.hotel.entity.Reservation;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

public interface ReservationDao {

    Reservation findById(Long id);

    List<Reservation> getAllReservations();

    List<Reservation> findByUsername(String username);

    Reservation updateReservation(Long id, Date checkIn, Date checkOut, Integer guests, String roomType);

    Reservation createOrUpdateReservation(Reservation reservation);

    void deleteReservationById(Long id);

    List<Reservation> findByCheckInAndCheckOutAndRoomType(Date checkIn, Date checkOut, String roomType);
}