		package com.capco.HROPS.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.capco.HROPS.model.User;



public interface AddNewUserRepository extends JpaRepository<User, Integer> {

	User findByusername(String username);
	
	User findByuserid(String userid);
	


	

}
