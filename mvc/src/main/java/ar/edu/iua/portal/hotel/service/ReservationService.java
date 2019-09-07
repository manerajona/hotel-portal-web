package ar.edu.iua.portal.hotel.service;

import ar.edu.iua.portal.hotel.dao.ReservationDao;
import ar.edu.iua.portal.hotel.entity.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class ReservationService {

	@Autowired
	@Qualifier("reservationDaoImpl")
	private ReservationDao reservationDao;

	public List<Reservation> getUserReservations(String username){
		return reservationDao.getUserReservations(username);
	}

	public Reservation updateReservation(Integer id, Timestamp newDateIn, Timestamp newDateOut, int newGuests){
		return reservationDao.updateReservation(id, newDateIn, newDateOut, newGuests);
	}

	public Reservation createReservation(Reservation reservation){
		return reservationDao.createReservation(reservation);
	}
}
