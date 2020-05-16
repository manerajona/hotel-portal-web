package ar.edu.iua.portal.hotel.model.entities;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "reservation")
public class Reservation {
    @Id
    @Column(name = "id_reservation")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "check_in", nullable = false)
    private Date checkIn;

    @Column(name = "check_out", nullable = false)
    private Date checkOut;

    @Column(nullable = false)
    private Integer guests;

    @Column(name="room_type", nullable=false)
    private String roomType;

    @Column(nullable = false)
    private String username;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(Date checkIn) {
        this.checkIn = checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(Date checkOut) {
        this.checkOut = checkOut;
    }

    public Integer getGuests() {
        return guests;
    }

    public void setGuests(Integer guests) {
        this.guests = guests;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
