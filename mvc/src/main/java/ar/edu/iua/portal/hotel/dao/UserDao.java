package ar.edu.iua.portal.hotel.dao;

import ar.edu.iua.portal.hotel.entity.User;

import java.util.List;

public interface UserDao {

    User findUserById(Long id);

    User updateUser(String username, String newPassword, String oldPassword);

    User createUser(User user);

    User findByUsername(String username);

    List<User> findAllUsers();

}