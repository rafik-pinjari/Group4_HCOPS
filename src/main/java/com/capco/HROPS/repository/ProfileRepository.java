
package com.capco.HROPS.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.capco.HROPS.model.User;



@Repository
public interface ProfileRepository extends JpaRepository<User, String>{

	@Query(value = "select * from user where userid=:userid", nativeQuery = true)
	User getByusername(@Param("userid")String userid);

	@Query(value = "select * from user where mail=:email", nativeQuery = true)
	User getByemail(@Param("email")String email);

}
