package ar.edu.iua.portal.hotel.model.repository;

import ar.edu.iua.portal.hotel.model.entities.ConfirmationToken;
import org.springframework.data.repository.CrudRepository;

public interface ConfirmationTokenRepository extends CrudRepository<ConfirmationToken, String> {
	ConfirmationToken findByConfirmationToken(String confirmationToken);
}
