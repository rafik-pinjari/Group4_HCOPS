package com.capco.HROPS.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;

import com.capco.HROPS.model.User;
import com.capco.HROPS.repository.LoginRepository;
import com.capco.HROPS.service.LoginService;

public class LoginServiceImpl implements LoginService{

	@Autowired
	private LoginRepository loginRepository;
	@Override
	public User findByUserName(String userName) {
		return loginRepository.findByuserid(userName);
		
	}

}
