package ar.edu.iua.portal.hotel.repository;

import ar.edu.iua.portal.hotel.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    @Query(value = "SELECT idreservation, datein, dateout, guests, iduser FROM reservation WHERE iduser = ?1", nativeQuery = true)
    Optional<List<Reservation>> findByUser(String user);

    @Query(value = "SELECT idreservation, datein, dateout, guests, iduser FROM reservation WHERE idreservation = ?1", nativeQuery = true)
    Optional<Reservation> findById(Integer id);
}
