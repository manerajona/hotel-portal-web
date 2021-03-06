package ar.edu.iua.portal.hotel.model.dao.impl;

import ar.edu.iua.portal.hotel.model.dao.ReservationDao;
import ar.edu.iua.portal.hotel.model.entities.Reservation;
import ar.edu.iua.portal.hotel.model.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;
import java.util.Locale;

@Repository
@Qualifier("reservationDaoImpl")
public class ReservationDaoImpl implements ReservationDao {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private MessageSource messageSource;

    @Override
    public Reservation findById(Long id) {
        return reservationRepository.findById(id).get();
    }

    @Override
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    @Override
    public Reservation updateReservation(Long id, Date checkIn, Date checkOut, Integer guests, String newRoom) {
        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(messageSource.getMessage(
                        "NotFound.Reservation", new Object[]{id}, Locale.getDefault())));
        reservation.setCheckIn(checkIn);
        reservation.setCheckOut(checkOut);
        reservation.setGuests(guests);
        reservation.setRoomType(newRoom);
        return reservationRepository.save(reservation);
    }

    @Override
    public Reservation createOrUpdateReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public void deleteReservationById(Long id) {
        reservationRepository.deleteById(id);
    }

    @Override
    public List<Reservation> findByCheckInAndCheckOutAndRoomType(Date checkIn, Date checkOut, String roomType) {
        return reservationRepository.findByCheckInAndCheckOutAndRoomType(checkIn, checkOut, roomType);
    }

    @Override
    public List<Reservation> findByUsername(String username) {
        return reservationRepository.findByUsername(username);
    }
}
