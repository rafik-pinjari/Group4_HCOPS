package com.capco.HROPS.service;

import java.util.List;

import com.capco.HROPS.custom.exception.HcopsException.HcopsServiceException;
import com.capco.HROPS.model.User;
import com.capco.HROPS.vio.UserVio;

public interface AddNewUserService {

	public User addNewUser(String userId, User user) throws HcopsServiceException;

	public Boolean deleteNewUse(String userId) throws HcopsServiceException;

	public List<User> getAllNewUsers() throws HcopsServiceException;
	
	public UserVio getUser(String userid) throws HcopsServiceException;
}