package ar.edu.iua.portal.hotel.model.dao.impl;

import ar.edu.iua.portal.hotel.model.entities.Message;

import ar.edu.iua.portal.hotel.model.repository.MessageRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.ArgumentMatchers.any;

public class MessageDaoImplTest {

    @Mock
    MessageRepository messageRepository;

    @InjectMocks
    private MessageDaoImpl messageDao;

    @BeforeEach
    public void setup() throws NoSuchAlgorithmException {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldReturnAllMessages() {
        // Given
        List<Message> expectedMessageList = createMockMessageList();
        // When
        Mockito.when(messageRepository.findAll()).thenReturn(expectedMessageList);
        List<Message> messageList = messageDao.getAllMessages();
        // Then
        assertFalse(messageList.isEmpty());
        assertThat(messageList, is(expectedMessageList));
     }

    @Test
    public void shouldCreateANewMessage() {
        // Given
        Message mockMessage = createMockMessage(messageMockData.M1_ID, messageMockData.M1_SUBJECT, messageMockData.M1_CONTENT, messageMockData.M1_EMAIL, messageMockData.M1_PHONE);
        // When
        Mockito.when(messageRepository.save(any(Message.class))).thenReturn(mockMessage);
        Message message = messageDao.createMessage(mockMessage);
        // Then
        assertEquals(messageMockData.M1_ID, message.getId());
        assertEquals(messageMockData.M1_CONTENT , message.getContent());
        assertEquals(messageMockData.M1_EMAIL, message.getEmail());
        assertEquals(messageMockData.M1_PHONE, message.getPhone());
        assertEquals(messageMockData.M1_SUBJECT, message.getSubject());
    }

    protected interface messageMockData {
        Long M1_ID = 1L;
        String M1_SUBJECT="Greets";
        String M1_CONTENT="Hello, thanks for everything!!";
        String M1_EMAIL="greet@happypeople.com";
        String M1_PHONE="1122333";
        Long M2_ID = 2L;
        String M2_SUBJECT="Question";
        String M2_CONTENT="Do you accept little pets? Thanks.";
        String M2_EMAIL="doglover@gmail.com";
        String M2_PHONE="(054) 44-658-9999";
    }

    protected List<Message> createMockMessageList () {
        Message message1 = createMockMessage(messageMockData.M1_ID, messageMockData.M1_SUBJECT, messageMockData.M1_CONTENT, messageMockData.M1_EMAIL, messageMockData.M1_PHONE);
        Message message2 = createMockMessage(messageMockData.M2_ID, messageMockData.M2_SUBJECT, messageMockData.M2_CONTENT, messageMockData.M2_EMAIL, messageMockData.M2_PHONE);

        List<Message> messageList = new ArrayList<Message>(){
            {
                add(message1);
                add(message2);
            }
        };
        return messageList;
    }

    protected Message createMockMessage(Long id, String subject, String content, String email, String phone) {
        Message m = new Message();
        m.setId(id);
        m.setSubject(subject);
        m.setContent(content);
        m.setEmail(email);
        m.setPhone(phone);
        return m;
    }
}