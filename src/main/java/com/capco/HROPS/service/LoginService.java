package com.capco.HROPS.service;
import org.springframework.stereotype.Service;
import com.capco.HROPS.model.User;



@Service
public interface LoginService{

	
	public User findByUserName(String userName);
	
}
