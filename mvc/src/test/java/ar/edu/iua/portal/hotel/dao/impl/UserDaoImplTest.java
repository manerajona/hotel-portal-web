package ar.edu.iua.portal.hotel.dao.impl;

import ar.edu.iua.portal.hotel.entity.User;
import ar.edu.iua.portal.hotel.repository.UserRepository;
import ar.edu.iua.portal.hotel.security.EncryptionHelper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.security.NoSuchAlgorithmException;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;


public class UserDaoImplTest {

    private User user;

    @Mock
    UserRepository userRepository;

    @InjectMocks
    private UserDaoImpl userDao;

    @Before
    public void setup() throws NoSuchAlgorithmException {
        MockitoAnnotations.initMocks(this);
        user = newUser();
    }

    @Ignore
    @Test
    public void shouldGetUserByUsernameAndPassword() throws NoSuchAlgorithmException {
        // when
        Mockito.doReturn(Optional.of(user)).when(userRepository).findByUserAndPassword(anyString(), anyString());
        User usr = userDao.getUser(userMockData.USER, userMockData.PASSWORD);
        // then
        assertNotNull(usr);
        assertEquals(userMockData.ID, usr.getId());
        assertEquals(userMockData.USER, usr.getUsername());
        Assert.assertEquals(EncryptionHelper.toSHA256(userMockData.PASSWORD), usr.getPassword());
        assertEquals(userMockData.EMAIL, usr.getEmail());
    }

    @Ignore
    @Test
    public void shouldThrowExceptionOnGetUserByUsernameAndPassword() {
        // TODO test
    }

    @Ignore
    @Test
    public void shouldUpdateUser() throws NoSuchAlgorithmException {
        // when
        Mockito.when(userRepository.save(any(User.class))).thenReturn(user);
        Mockito.doReturn(Optional.of(user)).when(userRepository).findByUserAndPassword(anyString(), anyString());
        User usr = userDao.updateUser(userMockData.USER, userMockData.NEW_PASSWORD, userMockData.PASSWORD);
        // then
        assertEquals(userMockData.ID, usr.getId());
        assertEquals(userMockData.USER, usr.getUsername());
        Assert.assertEquals(EncryptionHelper.toSHA256(userMockData.NEW_PASSWORD), usr.getPassword());
        assertEquals(userMockData.EMAIL, usr.getEmail());
    }

    @Ignore
    @Test
    public void shouldThrowExceptionOUpdateUser() {
        // TODO test
    }

    @Ignore
    @Test
    public void shouldCreateUser() throws NoSuchAlgorithmException {
        // when
        Mockito.when(userRepository.save(any(User.class))).thenReturn(user);
        User usr = userDao.createUser(user);
        // then
        assertEquals(userMockData.ID, usr.getId());
        assertEquals(userMockData.USER, usr.getUsername());
        Assert.assertEquals(EncryptionHelper.toSHA256(userMockData.PASSWORD), usr.getPassword());
        assertEquals(userMockData.EMAIL, usr.getEmail());
    }

    private User newUser() throws NoSuchAlgorithmException {
        User user = new User();
        user.setId(userMockData.ID);
        user.setUsername(userMockData.USER);
        user.setPassword(userMockData.PASSWORD);
        user.setEmail(userMockData.EMAIL);
        return user;
    }

    protected interface userMockData {
        Long ID = 1L;
        String USER = "panchov";
        String PASSWORD = "dollar60";
        String EMAIL = "panchov@gmail.com";
        String NEW_PASSWORD = "dollar70";
    }
}