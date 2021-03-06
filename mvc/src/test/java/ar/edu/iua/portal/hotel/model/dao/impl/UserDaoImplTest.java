package ar.edu.iua.portal.hotel.model.dao.impl;

import ar.edu.iua.portal.hotel.model.entities.User;
import ar.edu.iua.portal.hotel.model.repository.RoleRepository;
import ar.edu.iua.portal.hotel.model.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;

public class UserDaoImplTest {

    private User user;

    @Mock
    private UserRepository userRepository;

    @Mock
    private RoleRepository roleRepository;

    @Mock
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @InjectMocks
    private UserDaoImpl userDao;

    @BeforeEach
    public void setup() throws NoSuchAlgorithmException {
        MockitoAnnotations.initMocks(this);
        user = newUser();
    }

    @Test
    public void shouldGetUserByUsername() {
        // when
        Mockito.doReturn(Optional.of(user)).when(userRepository).findByUsername(anyString());
        User usr = userDao.findByUsername(userMockData.USER);
        // then
        assertNotNull(usr);
        assertEquals(userMockData.ID, usr.getId());
        assertEquals(userMockData.USER, usr.getUsername());
        assertEquals(userMockData.PASSWORD, usr.getPassword());
        assertEquals(userMockData.EMAIL, usr.getEmail());
    }

    @Test
    public void shouldGetUserByEmail() {
        // when
        Mockito.doReturn(user).when(userRepository).findByEmail(anyString());
        User usr = userDao.findByEmail(userMockData.EMAIL);
        // then
        assertNotNull(usr);
        assertEquals(userMockData.ID, usr.getId());
        assertEquals(userMockData.USER, usr.getUsername());
        assertEquals(userMockData.PASSWORD, usr.getPassword());
        assertEquals(userMockData.EMAIL, usr.getEmail());
    }

    @Test
    public void shouldGetAllUsers() {
        // when
        Mockito.doReturn(Arrays.asList(user)).when(userRepository).findAll();
        List<User> usrList = userDao.findAllUsers();
        // then
        assertNotNull(usrList);
        assertFalse(usrList.isEmpty());

        User usr = usrList.get(0);
        assertNotNull(usr);
        assertEquals(userMockData.ID, usr.getId());
        assertEquals(userMockData.USER, usr.getUsername());
        assertEquals(userMockData.PASSWORD, usr.getPassword());
        assertEquals(userMockData.EMAIL, usr.getEmail());
    }

    @Test
    public void shouldCreateOrUpdateUser() {
        // when
        String encodedPassword = new BCryptPasswordEncoder().encode(userMockData.NEW_PASSWORD);
        Mockito.doReturn(encodedPassword).when(bCryptPasswordEncoder).encode(anyString());

        Mockito.when(userRepository.save(any(User.class))).thenReturn(user);
        User usr = userDao.createOrUpdateUser(user);
        // then
        assertNotNull(usr);
        assertEquals(userMockData.ID, usr.getId());
        assertEquals(userMockData.USER, usr.getUsername());
        assertEquals(encodedPassword, usr.getPassword());
        assertEquals(userMockData.EMAIL, usr.getEmail());
    }

    @Test
    public void shouldUpdatePassword() {
        // when
        String encodedPassword = new BCryptPasswordEncoder().encode(userMockData.NEW_PASSWORD);
        Mockito.doReturn(encodedPassword).when(bCryptPasswordEncoder).encode(anyString());

        Mockito.when(userRepository.save(any(User.class))).thenReturn(user);
        User usr = userDao.updatePassword(user, userMockData.NEW_PASSWORD);
        // then
        assertNotNull(usr);
        assertEquals(userMockData.ID, usr.getId());
        assertEquals(userMockData.USER, usr.getUsername());
        assertEquals(encodedPassword, usr.getPassword());
        assertEquals(userMockData.EMAIL, usr.getEmail());
    }

    @Test
    public void shouldCreateUser() throws NoSuchAlgorithmException {
        // when
        String encodedPassword = new BCryptPasswordEncoder().encode(userMockData.NEW_PASSWORD);
        Mockito.doReturn(encodedPassword).when(bCryptPasswordEncoder).encode(anyString());

        Mockito.when(userRepository.save(any(User.class))).thenReturn(user);
        User usr = userDao.createOrUpdateUser(user);
        // then
        assertNotNull(usr);
        assertEquals(userMockData.ID, usr.getId());
        assertEquals(userMockData.USER, usr.getUsername());
        assertEquals(encodedPassword, usr.getPassword());
        assertEquals(userMockData.EMAIL, usr.getEmail());
    }

    private User newUser() {
        return User.builder()
                .id(userMockData.ID)
                .username(userMockData.USER)
                .password(userMockData.PASSWORD)
                .email(userMockData.EMAIL)
                .build();
    }

    protected interface userMockData {
        Long ID = 1L;
        String USER = "panchov";
        String PASSWORD = "dollar60";
        String EMAIL = "panchov@gmail.com";
        String NEW_PASSWORD = "dollar70";
    }
}