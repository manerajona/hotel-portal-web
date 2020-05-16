package ar.edu.iua.portal.hotel.model.dao.impl;

import ar.edu.iua.portal.hotel.model.dao.MessageDao;
import ar.edu.iua.portal.hotel.model.entities.Message;
import ar.edu.iua.portal.hotel.model.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Qualifier("messageDaoImpl")
public class MessageDaoImpl implements MessageDao {

    @Autowired
    private MessageRepository messageRepository;

    @Override
    public List<Message> getAllMessages() {
        return messageRepository.findAll();
    }

    @Override
    public Message createMessage(Message message) {
        return messageRepository.save(message);
    }

    @Override
    public void deleteMessageById(Long id) {
        messageRepository.deleteById(id);
    }
}
