package ar.edu.iua.portal.hotel.service;

import ar.edu.iua.portal.hotel.entity.User;

import java.util.List;

public interface UserService {
    void save(User user);

    User findByUsername(String username);

    User findByEmail(String email);

    List<User> findAllUsers();

    void deleteUser(Long id);

    User updateUser(String username, String newPassword, String oldPassword);
}
