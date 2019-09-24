package ar.edu.iua.portal.hotel.dao.impl;

import ar.edu.iua.portal.hotel.dao.ReservationDao;
import ar.edu.iua.portal.hotel.entity.Reservation;
import ar.edu.iua.portal.hotel.repository.ReservationRepository;
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
    public List<Reservation> getUserReservations(String username) {
        return reservationRepository.findByUsername(username).get();
    }

    @Override
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    @Override
    public Reservation updateReservation(Long id, Date newCheckIn, Date newCheckOut, Integer newGuests, String newRoom) {
        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(messageSource.getMessage(
                        "RESERVATION_WITH_ID_NOT_FOUND", new Object[]{id}, Locale.getDefault())));
        reservation.setCheckIn(newCheckIn);
        reservation.setCheckOut(newCheckOut);
        reservation.setGuests(newGuests);
        reservation.setRoomType(newRoom);
        return reservationRepository.save(reservation);
    }

    @Override
    public Reservation createReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

}
