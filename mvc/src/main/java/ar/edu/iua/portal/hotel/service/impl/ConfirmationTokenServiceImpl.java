package ar.edu.iua.portal.hotel.service.impl;

import ar.edu.iua.portal.hotel.entity.ConfirmationToken;
import ar.edu.iua.portal.hotel.repository.ConfirmationTokenRepository;
import ar.edu.iua.portal.hotel.service.ConfirmationTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConfirmationTokenServiceImpl implements ConfirmationTokenService {

    @Autowired
    private ConfirmationTokenRepository confirmationTokenRepository;

    @Override
    public boolean create(ConfirmationToken token) {
        return confirmationTokenRepository.save(token) != null;
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
