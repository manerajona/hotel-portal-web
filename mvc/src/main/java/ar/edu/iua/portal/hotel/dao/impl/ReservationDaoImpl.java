package ar.edu.iua.portal.hotel.dao.impl;

import ar.edu.iua.portal.hotel.dao.ReservationDao;
import ar.edu.iua.portal.hotel.entity.Reservation;

import java.sql.Timestamp;
import java.util.List;

public class ReservationDaoImpl implements ReservationDao {
    @Override
    public List<Reservation> getUserReservations(String username) {
        return null;
    }

    @Override
    public Reservation updateReservation(String username, Timestamp newDateIn, Timestamp newDateOut, int newGuests) {
        return null;
    }

    @Override
    public void createReservation(Reservation message) {

    }
}
