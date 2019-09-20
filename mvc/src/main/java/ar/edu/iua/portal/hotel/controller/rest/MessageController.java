package ar.edu.iua.portal.hotel.controller.rest;

import ar.edu.iua.portal.hotel.dao.MessageDao;
import ar.edu.iua.portal.hotel.entity.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/message")
public class MessageController {

    @Autowired
    @Qualifier("messageDaoImpl")
    private MessageDao messageDao;

    @RequestMapping(method = RequestMethod.GET)
    public List<Message> getAllMessages() {
        return messageDao.getAllMessages();
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Message createMessage(@RequestBody Message message) {
        return messageDao.createMessage(message);
    }
}
