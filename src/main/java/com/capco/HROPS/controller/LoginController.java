package com.capco.HROPS.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.capco.HROPS.model.User;
import com.capco.HROPS.repository.IncidentRepository;
import com.capco.HROPS.repository.LoginRepository;

@RestController
public class LoginController {

	private final Logger logger = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	LoginRepository loginRepository;
	
	@Autowired
	IncidentRepository inciRepo;

	@CrossOrigin
	@RequestMapping(value = "/login", method = RequestMethod.POST, headers = "Accept=application/json", produces = "application/json")
	public ResponseEntity<User> user(@RequestBody User user, HttpServletRequest request, HttpServletResponse response) {

		logger.info("Controller started, {}", user);
		HttpSession session = request.getSession();

		inciRepo.updateincident();
		User dbUser = null;
		String user2 = user.getUserid();

		try {
			logger.info("Login started, {}", user2);
			dbUser = loginRepository.findByuserid(user2);
			String id = dbUser.getUserid();
			String email = dbUser.getEmail();
			String username = dbUser.getUsername();

			if (dbUser.getUserid().equals(user.getUserid()) && dbUser.getPassword().equals(user.getPassword())) {
				if (dbUser.getActivity() == 0) {

					logger.error("Non active user, {}", dbUser);
					return new ResponseEntity<>(HttpStatus.NON_AUTHORITATIVE_INFORMATION);
				}
				session.setAttribute("Id", id);
				session.setAttribute("username", username);
				session.setAttribute("email", email);

				logger.info("logged in user, {}", id);
				logger.info("logged in username, {}", username);
				logger.info("logged in email, {}", email);
			} else {

				logger.error("Not found, {}", dbUser);
				return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
			}
			logger.info("Login Successfully, {}", user);
			return new ResponseEntity<User>(dbUser, HttpStatus.OK);

		} catch (Exception e) {
			logger.error("Not found, {}", dbUser);
			return new ResponseEntity<User>(dbUser, HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "/logout", method = RequestMethod.POST, headers = "Accept=application/json", produces = "application/json")
	public ResponseEntity<User> logout(HttpServletRequest request, HttpServletResponse response) {
		User user = new User();
		HttpSession session = request.getSession();
		String userName = (String) session.getAttribute("user");
		System.out.println("id before changed---------" + userName);
		userName = null;
		System.out.println("id after changed--------" + userName);
		session.invalidate();

		return new ResponseEntity<>(user, HttpStatus.OK);
	}

}