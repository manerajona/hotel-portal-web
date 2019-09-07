package ar.edu.iua.portal.hotel.dao.impl;

import ar.edu.iua.portal.hotel.cons.Imessages;
import ar.edu.iua.portal.hotel.dao.UserDao;
import ar.edu.iua.portal.hotel.security.EncryptionHelper;
import ar.edu.iua.portal.hotel.entity.User;
import ar.edu.iua.portal.hotel.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotBlank;
import java.security.NoSuchAlgorithmException;

@Repository
@Qualifier("userDaoImpl")
public class UserDaoImpl implements UserDao {

    @Autowired
	private UserRepository userRepository;

    @Override
    public User getUser(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format(Imessages.USER_WITH_ID_NOT_FOUND, id)));
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
                .orElseThrow(() -> new RuntimeException(Imessages.THE_USERNAME_OR_PASSWORD_ARE_INCORRECT));
    }

    @Override
    public User updateUser(String username, @NotBlank String newPassword, @NotBlank String oldPassword) {
        User usr = getUser(username, oldPassword);
        try {
            usr.setPassword(newPassword);
        } catch (NoSuchAlgorithmException e) {
            genericMessage();
        }
        return userRepository.save(usr);
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    private void genericMessage() {
        new RuntimeException(Imessages.SOMETHING_WENT_WRONG_PLEASE_TRY_AGAIN_LATER);
    }
}
