package ar.edu.iua.portal.hotel.repository;

import ar.edu.iua.portal.hotel.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    @Query(value = "SELECT id_reservation, check_in, check_out, guests, id_user FROM reservation WHERE id_user = (SELECT id_user from user where username = ?1", nativeQuery = true)
    Optional<List<Reservation>> findByUsername(String username);

}
