package ar.edu.iua.portal.hotel.dao.impl;

import ar.edu.iua.portal.hotel.entity.Reservation;
import ar.edu.iua.portal.hotel.repository.ReservationRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;

public class ReservationDaoImplTest {

    private Reservation reservationMock;

    @Mock
    private ReservationRepository reservationRepository;

    @InjectMocks
    private ReservationDaoImpl reservationDao;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        reservationMock = newReservation();
    }

    @Test
    public void shouldGetUserReservations() {
        // When
        Mockito.when(reservationRepository.findByUsername(anyString())).thenReturn(Optional.of(Arrays.asList(reservationMock)));
        List<Reservation> reservationList = reservationDao.getUserReservations(anyString());
        // Then
        Assert.assertFalse(reservationList.isEmpty());
        Reservation reservation = reservationList.get(0);
        Assert.assertEquals(reservationMockData.ID, reservation.getId());
        Assert.assertEquals(toSDate(reservationMockData.CHECK_IN), reservation.getCheckIn());
        Assert.assertEquals(toSDate(reservationMockData.CHECK_OUT), reservation.getCheckOut());
        Assert.assertEquals(reservationMockData.GUESTS, reservation.getGuests());
        Assert.assertEquals(reservationMockData.ROOM_TIPE, reservation.getRoomType());
        Assert.assertEquals(reservationMockData.USERNAME, reservation.getUsername());
    }

    @Test
    public void shouldUpdateReservation() {
        // Given
        java.sql.Date in = toSDate(reservationMockData.CHECK_IN);
        java.sql.Date out = toSDate(reservationMockData.CHECK_OUT);
        // When
        Mockito.when(reservationRepository.findById(any(Long.class))).thenReturn(Optional.of(reservationMock));
        Mockito.when(reservationRepository.save(any(Reservation.class))).thenReturn(reservationMock);
        Reservation reservation = reservationDao.updateReservation(reservationMockData.ID.longValue(), in, out, reservationMockData.GUESTS, reservationMockData.ROOM_TIPE);
        // Then
        Assert.assertEquals(reservationMockData.ID, reservation.getId());
        Assert.assertEquals(in, reservation.getCheckIn());
        Assert.assertEquals(out, reservation.getCheckOut());
        Assert.assertEquals(reservationMockData.GUESTS, reservation.getGuests());
        Assert.assertEquals(reservationMockData.ROOM_TIPE, reservation.getRoomType());
        Assert.assertEquals(reservationMockData.USERNAME, reservation.getUsername());
    }

    @Test
    public void shouldCreateReservation() {
        // When
        Mockito.when(reservationRepository.save(any(Reservation.class))).thenReturn(reservationMock);
        Reservation reservation = reservationDao.createReservation(reservationMock);
        // Then
        Assert.assertEquals(reservationMockData.ID, reservation.getId());
        Assert.assertEquals(toSDate(reservationMockData.CHECK_IN), reservation.getCheckIn());
        Assert.assertEquals(toSDate(reservationMockData.CHECK_OUT), reservation.getCheckOut());
        Assert.assertEquals(reservationMockData.GUESTS, reservation.getGuests());
        Assert.assertEquals(reservationMockData.ROOM_TIPE, reservation.getRoomType());
        Assert.assertEquals(reservationMockData.USERNAME, reservation.getUsername());
    }

    private Reservation newReservation() {
        Reservation reservation = new Reservation();
        reservation.setId(reservationMockData.ID);
        reservation.setCheckIn(toSDate(reservationMockData.CHECK_IN));
        reservation.setCheckOut(toSDate(reservationMockData.CHECK_OUT));
        reservation.setGuests(reservationMockData.GUESTS);
        reservation.setUsername(reservationMockData.USERNAME);
        reservation.setRoomType(reservationMockData.ROOM_TIPE);
        return reservation;
    }

    protected interface reservationMockData {
        Long ID = 1L;
        String CHECK_IN = "2020-04-26";
        String CHECK_OUT = "2020-04-27";
        String ROOM_TIPE = "Laxaries Room";
        Integer GUESTS = 3;
        String USERNAME = "myUser";
    }

    protected java.sql.Date toSDate(String t) {
        java.sql.Date date = null;
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date parsedDate = dateFormat.parse(t);
            date = new java.sql.Date(parsedDate.getTime());
        } catch(Exception e) {
            e.printStackTrace();
        }
        return date;
    }
}