package ar.edu.iua.portal.hotel.service;

import ar.edu.iua.portal.hotel.entity.User;
import org.springframework.validation.BindingResult;

import java.util.List;

public interface UserService {

    boolean createOrUpdate(User user, BindingResult bindingResult);

    User findByUsername(String username);

    User findByEmail(String email);

    List<User> findAllUsers();

    void deleteUser(Long id);

    User updatePassword(String username, String newPassword, String oldPassword);
}
