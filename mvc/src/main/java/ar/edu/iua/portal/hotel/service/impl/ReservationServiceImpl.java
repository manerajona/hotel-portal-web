package ar.edu.iua.portal.hotel.service.impl;

import ar.edu.iua.portal.hotel.dao.ReservationDao;
import ar.edu.iua.portal.hotel.entity.Reservation;
import ar.edu.iua.portal.hotel.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

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

}
