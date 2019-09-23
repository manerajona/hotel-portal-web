package ar.edu.iua.portal.hotel.service.impl;

import ar.edu.iua.portal.hotel.dao.impl.MessageDaoImpl;
import ar.edu.iua.portal.hotel.entity.Message;
import ar.edu.iua.portal.hotel.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Qualifier("messageServiceImpl")
public class MessageServiceImpl implements MessageService {

    @Autowired
    @Qualifier("messageDaoImpl")
    private MessageDaoImpl messageDao;

    @Override
    public void save(Message message) {
        messageDao.createMessage(message);
    }

    @Override
    public List<Message> findAllMessages() {
        return messageDao.getAllMessages();
    }

}
