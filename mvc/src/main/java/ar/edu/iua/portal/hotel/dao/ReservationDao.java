package ar.edu.iua.portal.hotel.dao;

import ar.edu.iua.portal.hotel.entity.Reservation;

import javax.validation.constraints.NotBlank;
import java.sql.Timestamp;
import java.util.List;

public interface ReservationDao {

    List<Reservation> getUserReservations(String username);

    List<Reservation> getAllReservations();

    Reservation updateReservation(@NotBlank Integer id, @NotBlank Timestamp newDateIn, @NotBlank Timestamp newDateOut, @NotBlank Integer newGuests);

    Reservation createReservation(Reservation reservation);

}