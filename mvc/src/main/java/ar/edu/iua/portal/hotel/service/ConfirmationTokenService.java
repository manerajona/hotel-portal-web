package ar.edu.iua.portal.hotel.service;

import ar.edu.iua.portal.hotel.entity.ConfirmationToken;

public interface ConfirmationTokenService {

    boolean create(ConfirmationToken token);

    ConfirmationToken findByConfirmationToken(String token);

    void deleteToken(ConfirmationToken t);
}
