package com.capco.HROPS.repository;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.capco.HROPS.model.User;


@Repository
public interface RegistrationRepository extends JpaRepository<User, Long> {
	@Query(value = "SELECT id FROM user group by id DESC limit 1", nativeQuery = true)
	String getid();
	
	User  findByuserid(String userid);
	
	@Transactional
	@Modifying
	@Query(value = "update user set activity=1 where userid=:userId", nativeQuery = true)
	int activateUser(@Param("userId") String userId); 
}

