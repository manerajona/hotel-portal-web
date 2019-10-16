package ar.edu.iua.portal.hotel.service.impl;

import ar.edu.iua.portal.hotel.dao.ReservationDao;
import ar.edu.iua.portal.hotel.entity.Reservation;
import ar.edu.iua.portal.hotel.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
@Qualifier("messageServiceImpl")
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    @Qualifier("reservationDaoImpl")
    private ReservationDao reservationDao;

    @Override
    public void save(Reservation reservation) {
        reservationDao.createReservation(reservation);
    }

    @Override
    public List<Reservation> findAllReservations() {
        return reservationDao.getAllReservations();
    }

    @Override
    public void deleteReservation(Long id) {
        reservationDao.deleteReservationById(id);
    }

    @Override
    public Reservation updateReservation(Long id, Date newCheckIn, Date newCheckOut, Integer newGuests, String newRoomType) {
        return reservationDao.updateReservation(id, newCheckIn, newCheckOut, newGuests, newRoomType);
    }
}
