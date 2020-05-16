package ar.edu.iua.portal.hotel.model.dao.impl;

import ar.edu.iua.portal.hotel.model.entities.Reservation;
import ar.edu.iua.portal.hotel.model.repository.ReservationRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;

public class ReservationDaoImplTest {

    private Reservation reservationMock;

    @Mock
    private ReservationRepository reservationRepository;

    @InjectMocks
    private ReservationDaoImpl reservationDao;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        reservationMock = newReservation();
    }

    @Test
    public void shouldFindById() {
        // When
        Mockito.when(reservationRepository.findById(anyLong())).thenReturn(Optional.of(reservationMock));
        Reservation reservation = reservationDao.findById(anyLong());
        // Then
        assertEquals(reservationMockData.ID, reservation.getId());
        assertEquals(toSDate(reservationMockData.CHECK_IN), reservation.getCheckIn());
        assertEquals(toSDate(reservationMockData.CHECK_OUT), reservation.getCheckOut());
        assertEquals(reservationMockData.GUESTS, reservation.getGuests());
        assertEquals(reservationMockData.ROOM_TIPE, reservation.getRoomType());
        assertEquals(reservationMockData.USERNAME, reservation.getUsername());
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
        assertEquals(reservationMockData.ID, reservation.getId());
        assertEquals(in, reservation.getCheckIn());
        assertEquals(out, reservation.getCheckOut());
        assertEquals(reservationMockData.GUESTS, reservation.getGuests());
        assertEquals(reservationMockData.ROOM_TIPE, reservation.getRoomType());
        assertEquals(reservationMockData.USERNAME, reservation.getUsername());
    }

    @Test
    public void shouldCreateReservation() {
        // When
        Mockito.when(reservationRepository.save(any(Reservation.class))).thenReturn(reservationMock);
        Reservation reservation = reservationDao.createOrUpdateReservation(reservationMock);
        // Then
        assertEquals(reservationMockData.ID, reservation.getId());
        assertEquals(toSDate(reservationMockData.CHECK_IN), reservation.getCheckIn());
        assertEquals(toSDate(reservationMockData.CHECK_OUT), reservation.getCheckOut());
        assertEquals(reservationMockData.GUESTS, reservation.getGuests());
        assertEquals(reservationMockData.ROOM_TIPE, reservation.getRoomType());
        assertEquals(reservationMockData.USERNAME, reservation.getUsername());
    }

    @Test
    public void shouldFindByUsername(){
        // When
        Mockito.when(reservationRepository.findByUsername(anyString())).thenReturn(Arrays.asList(reservationMock));
        List<Reservation> reservationList = reservationDao.findByUsername(anyString());
        // Then
        assertNotNull(reservationList);
        assertFalse(reservationList.isEmpty());

        Reservation reservation = reservationList.get(0);
        assertEquals(reservationMockData.ID, reservation.getId());
        assertEquals(toSDate(reservationMockData.CHECK_IN), reservation.getCheckIn());
        assertEquals(toSDate(reservationMockData.CHECK_OUT), reservation.getCheckOut());
        assertEquals(reservationMockData.GUESTS, reservation.getGuests());
        assertEquals(reservationMockData.ROOM_TIPE, reservation.getRoomType());
        assertEquals(reservationMockData.USERNAME, reservation.getUsername());
    }

    @Test
    public void shouldGetAllReservation(){
        // When
        Mockito.when(reservationRepository.findAll()).thenReturn(Arrays.asList(reservationMock));
        List<Reservation> reservationList = reservationDao.getAllReservations();
        // Then
        assertNotNull(reservationList);
        assertFalse(reservationList.isEmpty());

        Reservation reservation = reservationList.get(0);
        assertEquals(reservationMockData.ID, reservation.getId());
        assertEquals(toSDate(reservationMockData.CHECK_IN), reservation.getCheckIn());
        assertEquals(toSDate(reservationMockData.CHECK_OUT), reservation.getCheckOut());
        assertEquals(reservationMockData.GUESTS, reservation.getGuests());
        assertEquals(reservationMockData.ROOM_TIPE, reservation.getRoomType());
        assertEquals(reservationMockData.USERNAME, reservation.getUsername());
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