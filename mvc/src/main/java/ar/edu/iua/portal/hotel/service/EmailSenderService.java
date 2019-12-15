package ar.edu.iua.portal.hotel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service("emailSenderService")
public class EmailSenderService {

  private JavaMailSender javaMailSender;

  @Autowired
  public EmailSenderService(JavaMailSender javaMailSender) {
    this.javaMailSender = javaMailSender;
  }
  
  @Async
  public void sendEmail(SimpleMailMessage email) {
	  javaMailSender.send(email);
  }

  public void sendEmail(String email, String subject, String from, String content) {
    SimpleMailMessage mailMessage = new SimpleMailMessage();
    mailMessage.setTo(email);
    mailMessage.setSubject(subject);
    mailMessage.setFrom(from);
    mailMessage.setText(content);
    sendEmail(mailMessage);
  }
}
