package com.capco.HROPS.repository;


import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.capco.HROPS.model.Request;
;

public interface ReqRepository extends JpaRepository<Request, Long> {

	@Transactional
	@Modifying
	@Query(value = "insert into  request(created_at,description,incident_id) values(current_timestamp(),:description, :incidentId)", nativeQuery = true)
	int setStatus(@Param("description") String description,@Param("incidentId") String incidentId);
	
}
