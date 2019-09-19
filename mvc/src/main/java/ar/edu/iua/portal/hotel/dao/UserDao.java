package ar.edu.iua.portal.hotel.dao;

import ar.edu.iua.portal.hotel.entity.User;

public interface UserDao {

    User findUserById(Long id);

    User updateUser(String username, String newPassword, String oldPassword);

    User createUser(User user);

    User findByUsername(String username);

}