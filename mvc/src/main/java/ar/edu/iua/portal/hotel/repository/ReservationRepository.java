package ar.edu.iua.portal.hotel.repository;

import ar.edu.iua.portal.hotel.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    List<Reservation> findByUsername(String username);

    @Query("SELECT r FROM Reservation r where r.roomType = ?3 AND (r.checkIn BETWEEN ?1 AND ?2 OR r.checkOut BETWEEN ?1 AND ?2)")
    List<Reservation> findByCheckInAndCheckOutAndRoomType(Date checkIn, Date checkOut, String roomType);
}
