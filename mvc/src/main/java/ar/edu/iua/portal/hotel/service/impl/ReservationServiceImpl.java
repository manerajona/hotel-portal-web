package ar.edu.iua.portal.hotel.service.impl;

import ar.edu.iua.portal.hotel.dao.ReservationDao;
import ar.edu.iua.portal.hotel.entity.Reservation;
import ar.edu.iua.portal.hotel.service.ReservationService;
import ar.edu.iua.portal.hotel.validator.ReservationValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.sql.Date;
import java.util.List;

@Service
@Qualifier("messageServiceImpl")
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    @Qualifier("reservationDaoImpl")
    private ReservationDao reservationDao;

    @Autowired
    private ReservationValidator reservationValidator;

    @Override
    public boolean createOrUpdate(Reservation reservation, String username, BindingResult bindingResult) {

        reservation.setUsername(username);
        reservationValidator.validate(reservation, bindingResult);

        boolean success = !(bindingResult.hasErrors());
        if (success) {
            reservationDao.createOrUpdateReservation(reservation);
        }
        return success;
    }

    @Override
    public List<Reservation> findAllReservations() {
        return reservationDao.getAllReservations();
    }

    @Override
    public Reservation findById(Long id) {
        return reservationDao.findById(id);
    }

    @Override
    public void deleteReservation(Long id) {
        reservationDao.deleteReservationById(id);
    }

    @Override
    public List<Reservation> findReservationsByUsername(String username) {
        return reservationDao.findByUsername(username);
    }

    @Override
    public List<Reservation> findByCheckInAndCheckOutAndRoomType(Date checkIn, Date checkOut, String roomType) {
        return reservationDao.findByCheckInAndCheckOutAndRoomType(checkIn, checkOut, roomType);
    }


}
