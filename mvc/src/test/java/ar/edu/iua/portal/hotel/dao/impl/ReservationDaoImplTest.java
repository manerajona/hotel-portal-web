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
        Assert.assertEquals(toTimestamp(reservationMockData.CHECK_IN), reservation.getCheckIn());
        Assert.assertEquals(toTimestamp(reservationMockData.CHECK_OUT), reservation.getCheckOut());
        Assert.assertEquals(reservationMockData.GUESTS, reservation.getGuests());
        Assert.assertEquals(reservationMockData.ID_USER, reservation.getIdUser());
    }

    @Test
    public void shouldUpdateReservation() {
        // Given
        Timestamp in = toTimestamp(reservationMockData.CHECK_IN);
        Timestamp out = toTimestamp(reservationMockData.CHECK_OUT);
        // When
        Mockito.when(reservationRepository.findById(any(Long.class))).thenReturn(Optional.of(reservationMock));
        Mockito.when(reservationRepository.save(any(Reservation.class))).thenReturn(reservationMock);
        Reservation reservation = reservationDao.updateReservation(reservationMockData.ID.longValue(), in, out, reservationMockData.GUESTS);
        // Then
        Assert.assertEquals(reservationMockData.ID, reservation.getId());
        Assert.assertEquals(in, reservation.getCheckIn());
        Assert.assertEquals(out, reservation.getCheckOut());
        Assert.assertEquals(reservationMockData.GUESTS, reservation.getGuests());
        Assert.assertEquals(reservationMockData.ID_USER, reservation.getIdUser());
    }

    @Test
    public void shouldCreateReservation() {
        // When
        Mockito.when(reservationRepository.save(any(Reservation.class))).thenReturn(reservationMock);
        Reservation reservation = reservationDao.createReservation(reservationMock);
        // Then
        Assert.assertEquals(reservationMockData.ID, reservation.getId());
        Assert.assertEquals(toTimestamp(reservationMockData.CHECK_IN), reservation.getCheckIn());
        Assert.assertEquals(toTimestamp(reservationMockData.CHECK_OUT), reservation.getCheckOut());
        Assert.assertEquals(reservationMockData.GUESTS, reservation.getGuests());
        Assert.assertEquals(reservationMockData.ID_USER, reservation.getIdUser());
    }

    private Reservation newReservation() {
        Reservation reservation = new Reservation();
        reservation.setId(reservationMockData.ID);
        reservation.setCheckIn(toTimestamp(reservationMockData.CHECK_IN));
        reservation.setCheckOut(toTimestamp(reservationMockData.CHECK_OUT));
        reservation.setGuests(reservationMockData.GUESTS);
        reservation.setIdUser(reservationMockData.ID_USER);
        return reservation;
    }

    protected interface reservationMockData {
        Integer ID = 1;
        String CHECK_IN = "2020-04-26 18:25:43.511";
        String CHECK_OUT = "2020-04-27 18:25:43.511";
        Integer GUESTS = 3;
        Integer ID_USER = 1;
    }

    protected Timestamp toTimestamp(String t) {
        Timestamp timestamp = null;
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
            Date parsedDate = dateFormat.parse(t);
            timestamp = new java.sql.Timestamp(parsedDate.getTime());
        } catch(Exception e) {
            e.printStackTrace();
        }
        return timestamp;
    }
}