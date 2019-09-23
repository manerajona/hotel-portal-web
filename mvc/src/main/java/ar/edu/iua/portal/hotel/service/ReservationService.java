package ar.edu.iua.portal.hotel.service;

import ar.edu.iua.portal.hotel.entity.Reservation;

import java.util.List;

public interface ReservationService {
    void save(Reservation reservation);
    List<Reservation> findAllReservations();
}
