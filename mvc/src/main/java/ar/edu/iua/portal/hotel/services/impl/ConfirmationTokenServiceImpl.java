package ar.edu.iua.portal.hotel.services.impl;

import ar.edu.iua.portal.hotel.model.entities.ConfirmationToken;
import ar.edu.iua.portal.hotel.model.repository.ConfirmationTokenRepository;
import ar.edu.iua.portal.hotel.services.ConfirmationTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class ConfirmationTokenServiceImpl implements ConfirmationTokenService {

    @Autowired
    private ConfirmationTokenRepository confirmationTokenRepository;

    @Override
    public boolean create(ConfirmationToken token) {
        return Objects.nonNull(confirmationTokenRepository.save(token));
    }

    @Override
    public ConfirmationToken findByConfirmationToken(String token) {
        return confirmationTokenRepository.findByConfirmationToken(token);
    }

    @Override
    public void deleteToken(ConfirmationToken t) {
        confirmationTokenRepository.delete(t);
    }

}
