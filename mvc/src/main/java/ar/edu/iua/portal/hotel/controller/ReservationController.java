package ar.edu.iua.portal.hotel.controller;

import ar.edu.iua.portal.hotel.entity.Reservation;
import ar.edu.iua.portal.hotel.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservation")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @RequestMapping(value = "/{usr}", method = RequestMethod.GET)
    public List<Reservation> getUserReservations(@PathVariable("usr") String usuario) {
        return this.reservationService.getUserReservations(usuario);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Reservation createReservation(@RequestBody Reservation reservation) {
        return this.reservationService.createReservation(reservation);
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Reservation updateReservation(@RequestBody Reservation reservation) {
        return this.reservationService.updateReservation(reservation.getId(), reservation.getDateIn(), reservation.getDateOut(), reservation.getGuests());
    }
}
