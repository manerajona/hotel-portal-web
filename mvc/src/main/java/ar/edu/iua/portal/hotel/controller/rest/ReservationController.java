package ar.edu.iua.portal.hotel.controller.rest;

import ar.edu.iua.portal.hotel.dao.ReservationDao;
import ar.edu.iua.portal.hotel.entity.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservation")
public class ReservationController {

    @Autowired
    @Qualifier("reservationDaoImpl")
    private ReservationDao reservationDao;

    @RequestMapping(value = "/{usr}", method = RequestMethod.GET)
    public List<Reservation> getUserReservations(@PathVariable("usr") String usuario) {
        return reservationDao.getUserReservations(usuario);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Reservation createReservation(@RequestBody Reservation reservation) {
        return reservationDao.createReservation(reservation);
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Reservation updateReservation(@RequestBody Reservation reservation) {
        return reservationDao.updateReservation(reservation.getId().longValue(), reservation.getCheckIn(), reservation.getCheckOut(), reservation.getGuests(), reservation.getRoomType());
    }
}
