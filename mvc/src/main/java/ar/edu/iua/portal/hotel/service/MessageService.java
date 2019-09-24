package ar.edu.iua.portal.hotel.service;

import ar.edu.iua.portal.hotel.entity.Message;

import java.util.List;

public interface MessageService {

    void save(Message message);

    List<Message> findAllMessages();
}
