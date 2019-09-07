package ar.edu.iua.portal.hotel.dao;

import ar.edu.iua.portal.hotel.entity.Message;

import java.util.List;

public interface MessageDao {

    List<Message> getAllMessages();

    Message createMessage(Message message);

}