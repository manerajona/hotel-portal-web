package ar.edu.iua.portal.hotel.service;

import ar.edu.iua.portal.hotel.entity.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
