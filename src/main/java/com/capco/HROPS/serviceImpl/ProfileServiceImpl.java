package com.capco.HROPS.serviceImpl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Service;

import com.capco.HROPS.custom.exception.HcopsException.HcopsServiceException;
import com.capco.HROPS.custom.exception.HcopsException.ResourceNotFoundException;
import com.capco.HROPS.model.User;
import com.capco.HROPS.repository.ProfileRepository;
import com.capco.HROPS.service.ProfileService;



@Service
public class ProfileServiceImpl implements ProfileService{

	@Autowired
	private ProfileRepository profileRepository;
	
	@Override
	public List<User> getAllUsers() throws HcopsServiceException{
		try {
			return profileRepository.findAll();
			
		}
		catch(ResourceNotFoundException e) {
			throw new HcopsServiceException(e);
		}
		
	}

	@Override
	public User getByUsername(String username) throws HcopsServiceException{

		try {
			return profileRepository.getByusername(username);
			
		}
		catch(ResourceNotFoundException e) {
			throw new HcopsServiceException(e);
		}
		
	}

	@Override
	public User getByEmail(String email) throws HcopsServiceException{

		try {
			return profileRepository.getByemail(email);
		}
		catch(ResourceNotFoundException e) {
			throw new HcopsServiceException(e);
		}
	}

	@Override
	public User updateByUserId(String username, User user) throws HcopsServiceException {
		try {
			User user1=profileRepository.getByusername(username);
			if(user1==null) {
				return null;
			}
			else {
				user.setActivity(1);
				user1=user;
				profileRepository.save(user1);
				
				return user1;
			}
		}
		catch(ResourceNotFoundException e) {
			throw new HcopsServiceException(e);
		}
			
	}

	@Override
	public Boolean deleteUser(String username) throws HcopsServiceException{
		try {
			User user1=profileRepository.getByusername(username);
			if(user1==null) {
				return false;
			}
			else {
				user1.setActivity(0);
				profileRepository.save(user1);
				return true;
			}
		}
		catch(ResourceNotFoundException e) {
			throw new HcopsServiceException(e);
		}	
		
	}

}
