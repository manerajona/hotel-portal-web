package ar.edu.iua.portal.hotel.model.dao;

import ar.edu.iua.portal.hotel.model.entities.User;

import java.util.List;

public interface UserDao {

    User updatePassword(User user, String newPassword);

    User createOrUpdateUser(User user);

    User findByUsername(String username);

    User findByEmail(String email);

    List<User> findAllUsers();

    void deleteUserById(Long id);
}