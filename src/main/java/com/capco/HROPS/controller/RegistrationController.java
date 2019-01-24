package com.capco.HROPS.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.capco.HROPS.custom.exception.HcopsException.HcopsServiceException;
import com.capco.HROPS.custom.exception.HcopsException.ResourceNotFoundException;
import com.capco.HROPS.model.User;
import com.capco.HROPS.repository.RegistrationRepository;
import com.capco.HROPS.service.RegistrationService;

@RestController
@RequestMapping("/registration")
public class RegistrationController {

	private static final Logger logger = LoggerFactory.getLogger(RegistrationController.class);

	@Autowired
	private RegistrationService userRegistrationService;

	@Autowired
	private RegistrationRepository registrationRepository;

	@CrossOrigin
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@PostMapping("/save")
	public ResponseEntity<Void> createUser(HttpServletRequest request, @Valid @RequestBody User user) throws Exception {

		logger.info("Controller started, {}", user);
		HttpSession session = request.getSession();

		String userid = user.getUserid();
		if (registrationRepository.findByuserid(userid) != null)

		{
			logger.error("Already reported, {}", userid);
			return new ResponseEntity("Empty Data ", HttpStatus.ALREADY_REPORTED);
		}
		if (user.getUserid() == null || user.getPassword() == null || user.getEmail() == null
				|| user.getUsername() == null) {
			System.out.println("user Id  : " + user.getUserid() + " Email: " + user.getEmail() + " password: "
					+ user.getPassword() + " username: " + user.getUsername());

			logger.error("Null reported, {}", session);
			return new ResponseEntity("Empty Data ", HttpStatus.INTERNAL_SERVER_ERROR);
		} else {
			
			try {

				logger.info("User started, {}", user);
				userRegistrationService.createUser(user);
				/*
				 * System.out.println("user object:" + user.toString());
				 * System.out.println("user Id  : " + user.getUserid() + " Email: " +
				 * user.getEmail() + " password: " + user.getPassword() + " name: " +
				 * user.getUsername());
				 */
				session.setAttribute("userId", user.getUserid());
			} catch (NullPointerException e) {

				throw new HcopsServiceException(e);
			}
			
			logger.info("Created, {}", user);
			return new ResponseEntity(HttpStatus.CREATED);
		}

	}

	@CrossOrigin
	@GetMapping("/activationlink")
	public ResponseEntity<Void> sendLink(HttpServletRequest request) throws HcopsServiceException {

		try {
			HttpSession session = request.getSession();
			String userId = (String) session.getAttribute("userId");
			registrationRepository.activateUser(userId);

		} catch (NullPointerException | ResourceNotFoundException e) {

			throw new HcopsServiceException(e);
		}
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

}
