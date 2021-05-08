package ar.edu.iua.portal.hotel.services;

import ar.edu.iua.portal.hotel.model.entities.ConfirmationToken;

public interface ConfirmationTokenService {

    boolean create(ConfirmationToken token);

    ConfirmationToken findByConfirmationToken(String token);

    void deleteToken(ConfirmationToken t);
}
