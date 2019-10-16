package ar.edu.iua.portal.hotel.dao;

import ar.edu.iua.portal.hotel.entity.User;

import java.util.List;

public interface UserDao {

    User updateUser(String username, String newPassword, String oldPassword);

    User createUser(User user);

    User findByUsername(String username);

    User findByEmail(String email);

    List<User> findAllUsers();

    void deleteUserById(Long id);
}