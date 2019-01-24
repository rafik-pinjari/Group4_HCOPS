
package com.capco.HROPS.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capco.HROPS.model.User;



@Repository
public interface MultipartRepository extends JpaRepository<User, Long> {
	
	User  findByusername(String username);
}
