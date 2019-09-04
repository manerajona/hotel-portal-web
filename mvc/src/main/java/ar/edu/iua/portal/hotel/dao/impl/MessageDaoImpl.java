package ar.edu.iua.portal.hotel.dao.impl;

import ar.edu.iua.portal.hotel.dao.MessageDao;
import ar.edu.iua.portal.hotel.entity.Message;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Qualifier("messageDaoImpl")
public class MessageDaoImpl implements MessageDao {
    @Override
    public List<Message> getAllMessages() {
        return null;
    }

    @Override
    public void createMessage(Message message) {

    }
}
