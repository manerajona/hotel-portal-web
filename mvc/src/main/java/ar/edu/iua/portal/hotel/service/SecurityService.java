package ar.edu.iua.portal.hotel.service;

public interface SecurityService {

    String findLoggedInUsername();

    void autoLogin(String username, String password);
}
