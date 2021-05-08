package ar.edu.iua.portal.hotel.services;

import ar.edu.iua.portal.hotel.model.entities.Message;
import org.springframework.ui.Model;

import java.util.List;

public interface MessageService {

    void save(Message message, String username, Model model);

    List<Message> findAllMessages();

    void deleteMessage(Long id);
}
