package ar.edu.iua.portal.hotel.services.impl;

import ar.edu.iua.portal.hotel.model.dao.UserDao;
import ar.edu.iua.portal.hotel.model.entities.User;
import ar.edu.iua.portal.hotel.services.UserService;
import ar.edu.iua.portal.hotel.validators.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.List;

@Service
@Qualifier("userServiceImpl")
public class UserServiceImpl implements UserService {

    @Autowired
    @Qualifier("userDaoImpl")
    private UserDao userDao;

    @Autowired
    private UserValidator userValidator;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public boolean createOrUpdateAndValidate(User user, BindingResult bindingResult) {
        userValidator.validate(user, bindingResult);
        boolean success = !(bindingResult.hasErrors());
        if(success) {
            userDao.createOrUpdateUser(user);
        }
        return success;
    }

    @Override
    public void createOrUpdate(User user) {
        userDao.createOrUpdateUser(user);
    }

    @Override
    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }

    @Override
    public User findByEmail(String email) {
        return userDao.findByEmail(email);
    }

    @Override
    public List<User> findAllUsers() {
        return userDao.findAllUsers();
    }

    @Override
    public void deleteUser(Long id) {
        userDao.deleteUserById(id);
    }

    @Override
    public boolean updatePassword(String username, String newPassword, String oldPassword) {
        User user = userDao.findByUsername(username);
        boolean success = bCryptPasswordEncoder.matches(oldPassword, user.getPassword());
        if(success) {
            userDao.updatePassword(user, newPassword);
        }
        return success;
    }


}
