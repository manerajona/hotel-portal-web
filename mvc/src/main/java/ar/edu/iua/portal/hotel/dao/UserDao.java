package ar.edu.iua.portal.hotel.dao;

import ar.edu.iua.portal.hotel.entity.User;

public interface UserDao {

    User getUser(Long id);

    User getUser(String user, String password);

    void updateUser(String username, String newPassword, String oldPassword);

    void createUser(User user);

}