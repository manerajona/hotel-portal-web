package ar.edu.iua.portal.hotel.model.dao;

import ar.edu.iua.portal.hotel.model.entities.Message;

import java.util.List;

public interface MessageDao {

    List<Message> getAllMessages();

    Message createMessage(Message message);

    void deleteMessageById(Long id);

}