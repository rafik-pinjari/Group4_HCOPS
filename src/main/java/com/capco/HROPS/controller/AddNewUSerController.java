package com.capco.HROPS.controller;

import java.util.List;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.capco.HROPS.custom.exception.HcopsException.HcopsServiceException;
import com.capco.HROPS.model.User;
import com.capco.HROPS.service.AddNewUserService;
import com.capco.HROPS.vio.UserVio;

@RestControlleyhwj
@RequestMapping("/addNewUser")
@SuppressWarnings({ "unchecked", "rawtypes" })
public class AddNewUSerController {

	@Autowired
	private AddNewUserService addNewUserService;

	

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@PostMapping("/save/{userId}")
	public ResponseEntity<User> addNewUser(@PathVariable(value = "username") String username,
			@Valid @RequestBody User user) throws HcopsServiceException {
		if (username == null || user == null) {
			logger.error("addNewUser controller : addNewUser : nullUserId, {}", "no data");
			return new ResponseEntity("empty data", HttpStatus.NOT_FOUND);
		} else {
			try {
				User user1 = addNewUserService.addNewUser(username, user);
				if (user1 == null) {
					logger.error("addNewUser controller : addNewUser : nullUser, {}", "not available");
					return new ResponseEntity("empty data", HttpStatus.NOT_FOUND);
				} else {
					logger.info("addNewUser controller : addNewUser : userIsPresent, {}", "");
					return new ResponseEntity("data available", HttpStatus.OK);
				}
			} catch (Exception e) {
				logger.error("addNewUserController: addNewUser: Exception Caught, {}", e);
				throw new HcopsServiceException(e);
			}
		}

	}

	@PostMapping("/delete/{username}")
	public ResponseEntity<Void> deleteNewUser(@PathVariable(value = "username") String username)
			throws HcopsServiceException {
		logger.info("addNewUserController : deleteNewUser : started ,{}", "");
		if (username == null) {
			logger.error("addNewUserController : deleteNewUser : nullUserId ,{}", "");
			return new ResponseEntity("no available Data ", HttpStatus.NOT_ACCEPTABLE);

		} else {
			try {
				Boolean flag = addNewUserService.deleteNewUse(username);

				if (flag == false) {
					logger.error("addNewUserController : deleteNewUser : falseFlag ,{}", "");
					return new ResponseEntity("Empty Data ", HttpStatus.NOT_FOUND);
				} else {
					logger.info("addNewUserController : deleteNewUser : ended ,{}", "data get deleted");
					return ResponseEntity.ok().build();
				}
			} catch (Exception e) {
				logger.error("addNewUserController : deleteNewUser : exceptionCaught ,{}", e);
				throw new HcopsServiceException(e);
			}
		}

	}

	@GetMapping("/getAllNewUsers")
	public ResponseEntity<List<User>> getAllNewUsers() throws HcopsServiceException {
		try {
			logger.info("addNewUserController : deleteNewUser : ended ,{}", "data get deleted");
			List<User> user1 = addNewUserService.getAllNewUsers();
			if (user1.isEmpty()) {
				logger.error("addNewUserController : getAllUser : userIsEmpty ,{}", "no data available");
				return new ResponseEntity(HttpStatus.NOT_FOUND);
			} else {

				logger.info("addNewUserController : getAllUser : usersArePresent, {}", "data available");
				return new ResponseEntity(HttpStatus.FOUND);
			}
		} catch (Exception e) {
			logger.error("addNewUserController : getAllUser : Exception Caught,{}", e);
			throw new HcopsServiceException(e);
		}

	}

	@RequestMapping(value = "/getAdminDetail/{userid}", method = RequestMethod.GET)
	public ResponseEntity<UserVio> getUser(@PathVariable String userid) throws HcopsServiceException {

		try {
			logger.info("addNewUserController : getUser : started ,{}", "");
			UserVio userVio=addNewUserService.getUser(userid);
			
			if(userVio==null) {
				logger.error("addNewUserController : getUser : userIsEmpty ,{}", "no data available");
				return new ResponseEntity("Empty Data ", HttpStatus.NO_CONTENT);
			}
			else {
				logger.info("addNewUserController : getUser : ended ,{}", "");
				return new ResponseEntity(userVio, HttpStatus.OK);
			}
			
		}
		catch (Exception e) {
			logger.error("addNewUserController : getUser : Exception Caught,{}", e);
			throw new HcopsServiceException(e);
		}
	}
}
