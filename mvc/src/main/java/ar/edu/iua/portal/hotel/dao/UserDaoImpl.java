package ar.edu.iua.portal.hotel.dao;

import ar.edu.iua.portal.hotel.security.EncryptionHelper;
import ar.edu.iua.portal.hotel.entity.User;
import ar.edu.iua.portal.hotel.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.security.NoSuchAlgorithmException;

@Repository
@Qualifier("userDaoImpl")
public class UserDaoImpl implements UserDao {

	@Autowired
	private UserRepository userRepository;

    @Override
    public User getUser(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User with id " + id + " not found."));
    }

    @Override
    public User getUser(String user, String password) {
        String shaPassword=null;
        try {
            shaPassword = EncryptionHelper.toSHA256(password);
        } catch (NoSuchAlgorithmException e) {
            genericMessage();
        }
        return userRepository.findByUserAndPassword(user, shaPassword)
                .orElseThrow(() -> new RuntimeException("The username or password are incorrect."));
    }

    @Override
    public void updateUser(String username, String newPassword, String oldPassword) {
        User usr = getUser(username, oldPassword);
        try {
            usr.setPassword(newPassword);
        } catch (NoSuchAlgorithmException e) {
            genericMessage();
        }
        userRepository.save(usr);
    }

    @Override
    public void createUser(User user) {
        userRepository.save(user);
    }

    private void genericMessage() {
        new RuntimeException("something went wrong please try again later.");
    }
}
