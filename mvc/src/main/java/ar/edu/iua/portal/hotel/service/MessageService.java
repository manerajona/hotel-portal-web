package ar.edu.iua.portal.hotel.service;

import ar.edu.iua.portal.hotel.entity.Message;
import org.springframework.ui.Model;

import java.util.List;

public interface MessageService {

    void save(Message message, String username, Model model);

    List<Message> findAllMessages();

    void deleteMessage(Long id);
}
