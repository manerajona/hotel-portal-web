package ar.edu.iua.portal.hotel.service.impl;

import ar.edu.iua.portal.hotel.dao.MessageDao;
import ar.edu.iua.portal.hotel.entity.Message;
import ar.edu.iua.portal.hotel.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

@Service
@Qualifier("messageServiceImpl")
public class MessageServiceImpl implements MessageService {

    @Autowired
    @Qualifier("messageDaoImpl")
    private MessageDao messageDao;

    @Override
    public void save(Message message, String username, Model model) {
        message.setUsername(username);
        messageDao.createMessage(message);
        model.addAttribute("messageForm", new Message());
    }

    @Override
    public List<Message> findAllMessages() {
        return messageDao.getAllMessages();
    }

    @Override
    public void deleteMessage(Long id) {
        messageDao.deleteMessageById(id);
    }
}
