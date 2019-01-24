package com.capco.HROPS.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.capco.HROPS.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

	public Category findBycategoryName(String categoryName);

	public List<Category> findBycategoryid(Integer categoryid);
	
	@Query(value = "SELECT categoryid FROM category group by categoryid DESC limit 1", nativeQuery = true)
	  int getid(); 

}
