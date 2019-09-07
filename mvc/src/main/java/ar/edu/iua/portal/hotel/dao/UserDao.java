package ar.edu.iua.portal.hotel.dao;

import ar.edu.iua.portal.hotel.entity.User;

public interface UserDao {

    User getUser(Long id);

    User getUser(String user, String password);

    User updateUser(String username, String newPassword, String oldPassword);

    User createUser(User user);

}