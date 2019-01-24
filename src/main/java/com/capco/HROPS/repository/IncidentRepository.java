package com.capco.HROPS.repository;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.capco.HROPS.model.Incident;



public interface IncidentRepository extends JpaRepository<Incident, Long>{

	Incident findAllByincidentId(String incidentId);

	List<Incident> findAllByuserId(String userId);
	
	List<Incident> findAllBylocation(String location);
	
	@Query(value = "SELECT id FROM incident group by id DESC limit 1", nativeQuery = true)
	  String getid();
	
	 @Query(value = "SELECT * FROM incident where created_at like :createdAt% ", nativeQuery = true)
	 List<Incident> getDate(@Param("createdAt") String createdAt);
	 
	 @Transactional
		@Modifying
		@Query(value = "update incident set status='closed' where status='resolved' and  TIMESTAMPDIFF(HOUR,created_at,CURRENT_TIMESTAMP())>= 48 ", nativeQuery = true)
		int updateincident(); 
}
