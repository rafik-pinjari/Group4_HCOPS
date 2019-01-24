package com.capco.HROPS.service;
import org.springframework.stereotype.Service;
import com.capco.HROPS.model.Mail;
import com.capco.HROPS.model.User;


@Service
public interface MailSendService {
	
	public User sendMail( Mail mail) throws  Exception;

}
