package ar.edu.iua.portal.hotel.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "reservation")
public class Reservation {
    @Id
    @Column(name = "id_reservation")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "check_in", nullable = false)
    private Timestamp checkIn;

    @Column(name = "check_out", nullable = false)
    private Timestamp checkOut;

    @Column(nullable = false)
    private Integer guests;

    @Column(name="id_user", nullable = false)
    private Integer idUser;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Timestamp getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(Timestamp checkIn) {
        this.checkIn = checkIn;
    }

    public Timestamp getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(Timestamp checkOut) {
        this.checkOut = checkOut;
    }

    public Integer getGuests() {
        return guests;
    }

    public void setGuests(Integer guests) {
        this.guests = guests;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }
}
