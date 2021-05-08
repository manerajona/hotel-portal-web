package ar.edu.iua.portal.hotel.model.repository;

import ar.edu.iua.portal.hotel.model.entities.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
}
