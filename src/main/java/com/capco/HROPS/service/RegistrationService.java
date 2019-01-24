package com.capco.HROPS.service;

import org.springframework.stereotype.Service;

import com.capco.HROPS.custom.exception.HcopsException.HcopsServiceException;
import com.capco.HROPS.model.User;

@Service
public interface RegistrationService {

	public User createUser(User user) throws HcopsServiceException, Exception;
}
