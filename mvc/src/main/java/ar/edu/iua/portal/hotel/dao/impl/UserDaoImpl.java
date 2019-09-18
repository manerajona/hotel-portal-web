package ar.edu.iua.portal.hotel.dao.impl;

import ar.edu.iua.portal.hotel.cons.Imessages;
import ar.edu.iua.portal.hotel.dao.UserDao;
import ar.edu.iua.portal.hotel.entity.User;
import ar.edu.iua.portal.hotel.repository.RoleRepository;
import ar.edu.iua.portal.hotel.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.HashSet;

@Repository
@Qualifier("userDaoImpl")
public class UserDaoImpl implements UserDao {

    @Autowired
	private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public User getUser(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format(Imessages.USER_WITH_ID_NOT_FOUND, id)));
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User getUser(String user, String password) {
        String encode = bCryptPasswordEncoder.encode(password);
        return userRepository.findByUserAndPassword(user, encode)
                .orElseThrow(() -> new RuntimeException(Imessages.THE_USERNAME_OR_PASSWORD_ARE_INCORRECT));
    }

    @Override
    public User updateUser(String username, String newPassword, String oldPassword) {
        User usr = getUser(username, oldPassword);
        usr.setPassword(bCryptPasswordEncoder.encode(newPassword));
        return userRepository.save(usr);
    }

    @Override
    public User createUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(new HashSet<>(roleRepository.findAll()));
        return userRepository.save(user);
    }

}
