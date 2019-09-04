package ar.edu.iua.portal.hotel.service;

import ar.edu.iua.portal.hotel.dao.MessageDao;
import ar.edu.iua.portal.hotel.dao.UserDao;
import ar.edu.iua.portal.hotel.entity.Message;
import ar.edu.iua.portal.hotel.entity.User;
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
		return this.getAllMessages();
	}

	public Message createMessage(Message message){
		this.createMessage(message);
		return message;
	}
}
