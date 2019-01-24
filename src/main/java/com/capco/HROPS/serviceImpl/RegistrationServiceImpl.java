package com.capco.HROPS.serviceImpl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capco.HROPS.custom.exception.HcopsException.HcopsServiceException;
import com.capco.HROPS.custom.exception.HcopsException.ResourceNotFoundException;
import com.capco.HROPS.model.Mail;
import com.capco.HROPS.model.User;
import com.capco.HROPS.repository.RegistrationRepository;
import com.capco.HROPS.service.RegistrationService;



@Service
public class RegistrationServiceImpl implements RegistrationService {

	@Autowired
	private RegistrationRepository registrationRepository;
	@Autowired
	private MailSendServiceImpl mailsendservice;
	@Autowired
	Mail mail;
	@Override
	public User createUser(User user) throws Exception{
		
		String uid=registrationRepository.getid();
		String uname=user.getUserid();
		int i;
		int id;
		user.setUsergroup("user");
		  user.setActivity(0);
		try {
			 if(uid==null){
				  user.setId(1);
			  }
			  else 
			  { 
				  User user2;
				  user2=registrationRepository.findByuserid(uname);
				
				  if(user2==null) {
					  i = Integer.parseInt(uid);	
					   
					   id=i+1;
					   user.setId(id);
				  }
				  else{ 
					  i = Integer.parseInt(uid);	
					  id=i;
					  user.setId(id);
				  }		
			  }
		    	/* String receiver=user.getEmail();
		    	 String Subject= "To get started,click the link below to confirm your account  <a href=\"http://localhost:8080/registration/activationlink\">\n\nClick Here</a>";
		    	// String Subject= "To get started,click the link below to confirm your account  <a href=\"C:\\Users\\e5544303\\eclipse-workspace\\CapcoHROPS\\src\\main\\webApp\\hello.html\">\n\nClick Here</a>";
			    
		    	 
		    	 mail.setBody(Subject);
				mail.setReicever(receiver);
				mail.setSubject(Subject);
				mailsendservice.sendMail(mail);*/
			  
		}
		catch(ResourceNotFoundException e) {
			
			throw new HcopsServiceException(e);
		}
		
	
		return registrationRepository.save(user);
		  
	}
}
