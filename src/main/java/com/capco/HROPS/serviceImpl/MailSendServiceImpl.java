package com.capco.HROPS.serviceImpl;

import javax.mail.internet.InternetHeaders;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.capco.HROPS.model.Mail;
import com.capco.HROPS.model.User;
import com.capco.HROPS.service.MailSendService;

@Service
public class MailSendServiceImpl implements MailSendService {
	@Autowired
	 private JavaMailSender sender;
	
	@Autowired
	private Mail mail;
	
	@Override
    public User sendMail(Mail mail) throws Exception {
		InternetHeaders headers = new InternetHeaders();
		headers.addHeader("Content-type", "text/html; charset=UTF-8");
	
		 MimeMessage message = sender.createMimeMessage();
		 
         MimeMessageHelper helper = new MimeMessageHelper(message);
 
          helper.setTo(mail.getReicever());
 
         helper.setText(mail.getBody());
 
         helper.setSubject(mail.getSubject());
         String body = mail.getSubject();
         message.setText(body, "UTF-8", "html");
 
      
 
         sender.send(message);
	
		return null;
	}

}
