package com.capco.HROPS.repository;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capco.HROPS.model.City;





@Repository
public interface CityRepository extends JpaRepository<City, Long>{

	City findBycityName(String cityName);

	City findAllBycityName(String cityName);

	List<City> findByCountryName(String countryName);

	List<City> findBycreatedAt(Date result);

	City deleteBycityName(String cityName);

	@Query("select new com.capco.HROPS.model.City(c.cityName) from City c")
	List<City> getCities();
	

}
