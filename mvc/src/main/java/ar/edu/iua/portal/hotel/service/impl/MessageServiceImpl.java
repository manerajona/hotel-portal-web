package ar.edu.iua.portal.hotel.service.impl;

import ar.edu.iua.portal.hotel.entity.Message;
import ar.edu.iua.portal.hotel.repository.MessageRepository;
import ar.edu.iua.portal.hotel.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("messageServiceImpl")
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageRepository messageRepository;

    @Override
    public void save(Message message) {
        messageRepository.save(message);
    }

}
