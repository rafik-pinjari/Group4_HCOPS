package com.capco.HROPS.service;

import java.util.List;

import com.capco.HROPS.custom.exception.HcopsException.HcopsServiceException;
import com.capco.HROPS.model.User;



public interface ProfileService {

	public List<User> getAllUsers() throws HcopsServiceException;
	
	public User getByUsername(String username) throws HcopsServiceException;
	
	public User getByEmail(String email) throws HcopsServiceException;
	
	public User updateByUserId( String username,User user) throws HcopsServiceException;
	
	public Boolean deleteUser( String username) throws HcopsServiceException;
		
		

}
