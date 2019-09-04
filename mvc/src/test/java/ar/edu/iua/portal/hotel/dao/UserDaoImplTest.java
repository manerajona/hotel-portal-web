package ar.edu.iua.portal.hotel.dao;

import ar.edu.iua.portal.hotel.dao.impl.UserDaoImpl;
import ar.edu.iua.portal.hotel.entity.User;
import ar.edu.iua.portal.hotel.security.EncryptionHelper;
import ar.edu.iua.portal.hotel.repository.UserRepository;
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

    public static final Long ID = 1L;
    public static final String USER = "panchov";
    public static final String PASSWORD = "dollar60";
    public static final String EMAIL = "panchov@gmail.com";
    public static final String NEW_PASSWORD = "dollar70";

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

    @Test
    public void shouldGetUserByUsernameAndPassword() throws NoSuchAlgorithmException {
        // when
        Mockito.doReturn(Optional.of(user)).when(userRepository).findByUserAndPassword(anyString(), anyString());
        User usr = userDao.getUser(USER, PASSWORD);
        // then
        assertNotNull(usr);
        assertEquals(ID, usr.getId());
        assertEquals(USER, usr.getUsername());
        Assert.assertEquals(EncryptionHelper.toSHA256(PASSWORD), usr.getPassword());
        assertEquals(EMAIL, usr.getEmail());
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
        Mockito.doNothing().when(userRepository).save(any(User.class));
        userDao.updateUser(USER, NEW_PASSWORD, PASSWORD);
        // TODO test
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
        Mockito.doNothing().when(userRepository).save(any(User.class));
        userDao.createUser(user);
        // TODO test
    }

    private User newUser() throws NoSuchAlgorithmException {
        User user = new User();
        user.setId(ID);
        user.setUsername(USER);
        user.setPassword(PASSWORD);
        user.setEmail(EMAIL);
        return user;
    }
}