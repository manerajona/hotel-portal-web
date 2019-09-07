package ar.edu.iua.portal.hotel.service;

import ar.edu.iua.portal.hotel.dao.MessageDao;
import ar.edu.iua.portal.hotel.entity.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {

	@Autowired
	@Qualifier("messageDaoImpl")
	private MessageDao messageDao;

	public List<Message> getAllMessages(){
		return messageDao.getAllMessages();
	}

	public Message createMessage(Message message){
		return messageDao.createMessage(message);
	}
}
