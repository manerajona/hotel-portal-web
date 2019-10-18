package ar.edu.iua.portal.hotel.service.impl;

import ar.edu.iua.portal.hotel.dao.UserDao;
import ar.edu.iua.portal.hotel.entity.User;
import ar.edu.iua.portal.hotel.service.UserService;
import ar.edu.iua.portal.hotel.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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

    @Override
    public boolean createOrUpdate(User user, BindingResult bindingResult) {
        userValidator.validate(user, bindingResult);
        if (!bindingResult.hasErrors()) {
            userDao.createOrUpdateUser(user);
            return false;
        }
        return true;
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
    public User updatePassword(String username, String newPassword, String oldPassword) {
        return userDao.updatePassword(username, newPassword, oldPassword);
    }
}
