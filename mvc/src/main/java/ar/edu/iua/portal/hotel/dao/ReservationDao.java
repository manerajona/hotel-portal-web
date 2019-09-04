package ar.edu.iua.portal.hotel.dao;

import ar.edu.iua.portal.hotel.entity.Reservation;

import java.sql.Timestamp;
import java.util.List;

public interface ReservationDao {

    List<Reservation> getUserReservations(String username);

    Reservation updateReservation(String username, Timestamp newDateIn, Timestamp newDateOut, int newGuests);

    void createReservation(Reservation message);

}