package com.capco.HROPS.serviceImpl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capco.HROPS.custom.exception.HcopsException.HcopsServiceException;
import com.capco.HROPS.custom.exception.HcopsException.ResourceNotFoundException;
import com.capco.HROPS.model.City;
import com.capco.HROPS.model.User;
import com.capco.HROPS.repository.AddNewUserRepository;
import com.capco.HROPS.repository.CityRepository;
import com.capco.HROPS.service.AddNewUserService;
import com.capco.HROPS.vio.UserVio;

@Service
public class AddNewUserServiceImpl implements AddNewUserService {

	@Autowired
	private AddNewUserRepository addNewUserRepository;
	
	@Autowired
	private CityRepository cityRepository;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public User addNewUser(String username, User user) throws HcopsServiceException {
		try {
			User user1 = addNewUserRepository.findByusername(username);
			if (user1 == null) {
				return null;
			} else {
			
				user1.setUsergroup(user.getUsergroup());
				user1.setDepartment(user.getDepartment());

				return addNewUserRepository.save(user1);
			}
		} catch (ResourceNotFoundException e) {
			logger.error("CategoryServiceImpl : deleteCategory: Exception,{}",e);
			throw new HcopsServiceException(e);
		}

	}

	@Override
	public Boolean deleteNewUse(String username) throws HcopsServiceException {
		try {
			User user1 = addNewUserRepository.findByusername(username);
			if (user1 == null) {
				return false;
			} else {
				user1.setUsergroup("user");
				addNewUserRepository.save(user1);
				return true;
			}
		} catch (ResourceNotFoundException e) {
			logger.error("CategoryServiceImpl : deleteCategory: Exception,{}", e);
			throw new HcopsServiceException(e);
		}

	}

	@Override
	public List<User> getAllNewUsers() throws HcopsServiceException {
		try {
			return addNewUserRepository.findAll();
		} catch (ResourceNotFoundException e) {
			logger.error("CategoryServiceImpl : deleteCategory: Exception,{}", e);
			throw new HcopsServiceException(e);
		}

	}
	
	@SuppressWarnings("unused")
	public UserVio getUser(String userid) throws HcopsServiceException {

		try {
			logger.info("AddNewUserServiceImpl : getUser : ended ,{}", "");
			
			User user=null;
			City city=null;
			
			user = addNewUserRepository.findByuserid(userid);
			
			if(user==null) {
				
				return null;
			}
			else {
				String location = user.getLocation();

				city = cityRepository.findAllBycityName(location);
			}
			
			if (user == null) {
				logger.error("AddNewUserServiceImpl : getUser : Exception Caught,{}", "");
				return null;

			} 
			else {
				UserVio uservio = new UserVio();

				uservio.setUserid(user.getUserid());
				uservio.setCityName(city.getCityName());
				uservio.setCountryName(city.getCountryName());
				uservio.setStateName(city.getStateName());
				uservio.setDepartment(user.getDepartment());
				uservio.setEmail(user.getEmail());
				uservio.setLocation(user.getLocation());
				uservio.setPassword(user.getPassword());
				uservio.setProfilePic(user.getProfilePic());
				uservio.setUsergroup(user.getUsergroup());
				uservio.setUsername(user.getUsername());
				uservio.setActivity(user.getActivity());
				
				logger.info("AddNewUserServiceImpl : getUser : ended ,{}", "");
				return uservio;
			}
		}
		catch (Exception e) {
			logger.error("AddNewUserServiceImpl : getUser : Exception Caught,{}", e);
			throw new HcopsServiceException(e);
		}
	}

}
