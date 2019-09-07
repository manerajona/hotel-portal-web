package ar.edu.iua.portal.hotel.dao.impl;

import ar.edu.iua.portal.hotel.cons.Imessages;
import ar.edu.iua.portal.hotel.dao.ReservationDao;
import ar.edu.iua.portal.hotel.entity.Reservation;
import ar.edu.iua.portal.hotel.repository.ReservationRepository;
import com.google.common.base.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotBlank;
import java.sql.Timestamp;
import java.util.List;

@Repository
@Qualifier("reservationDaoImpl")
public class ReservationDaoImpl implements ReservationDao {

    protected static final int ZERO = 0;

    @Autowired
    ReservationRepository reservationRepository;

    @Override
    public List<Reservation> getUserReservations(String username) {
        return reservationRepository.findByUser(username)
                .orElseThrow(() -> new RuntimeException(Imessages.USERNAME_INCORRECT));
    }

    @Override
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    @Override
    public Reservation updateReservation(Integer id, @NotBlank Timestamp newDateIn, @NotBlank Timestamp newDateOut, @NotBlank Integer newGuests) {
        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format(Imessages.RESERVATION_WITH_ID_NOT_FOUND, id)));
        reservation.setDateIn(newDateIn);
        reservation.setDateOut(newDateOut);
        reservation.setGuests(newGuests.intValue());
        return checkReservationPreconditionsAndSave(reservation);
    }

    @Override
    public Reservation createReservation(Reservation reservation) {
        return checkReservationPreconditionsAndSave(reservation);
    }

    private Reservation checkReservationPreconditionsAndSave(Reservation reservation) {
        Preconditions.checkArgument(reservation.getDateIn().before(reservation.getDateOut()), Imessages.DATEIN_MUST_BE_BEFORE_DATEOUT);
        Preconditions.checkArgument(reservation.getGuests() > ZERO, Imessages.GUESTS_MUST_BE_GREATER_THAN_ZERO);
        return reservationRepository.save(reservation);
    }
}
