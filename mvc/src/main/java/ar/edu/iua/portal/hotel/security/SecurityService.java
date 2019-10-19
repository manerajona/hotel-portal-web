package ar.edu.iua.portal.hotel.security;

public interface SecurityService {

    String findLoggedInUsername();

    void autoLogin(String username, String password);

    boolean isAutenticated();
}
