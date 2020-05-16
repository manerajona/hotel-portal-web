package ar.edu.iua.portal.hotel.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component("emailSender")
public class EmailSender {

  @Autowired
  private JavaMailSender javaMailSender;

  @Async
  public void sendEmail(SimpleMailMessage email) {
	  javaMailSender.send(email);
  }

  public void sendEmail(String to, String subject, String from, String content) {
    SimpleMailMessage mailMessage = new SimpleMailMessage();
    mailMessage.setTo(to);
    mailMessage.setSubject(subject);
    mailMessage.setFrom(from);
    mailMessage.setText(content);
    sendEmail(mailMessage);
  }
}
