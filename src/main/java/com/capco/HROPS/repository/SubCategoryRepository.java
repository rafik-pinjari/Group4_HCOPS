package com.capco.HROPS.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.capco.HROPS.model.SubCategory;

public interface SubCategoryRepository  extends JpaRepository<SubCategory, Integer>  {
	public SubCategory findBysubcategoryname(String subCatName);

	@Query(value = "SELECT Subcategoryid FROM sub_category group by Subcategoryid DESC limit 1", nativeQuery = true)
	  int getid(); 

	@Transactional
	@Modifying
	@Query(value = "update sub_category set category_id=:cateId where subcategoryid=:subCatId", nativeQuery = true)
	int updateSub(@Param("subCatId") int subId,@Param ("cateId") int catId); 
	
	
	@Transactional
	@Modifying
	@Query(value = "insert into sub_category  (subcategoryname,category_id) values(:subcatname,:catId)", nativeQuery = true)
	int saveSubCat(@Param("subcatname") String subcatname,@Param("catId") int catId); 

	@Transactional
	@Modifying
	@Query(value = "delete from sub_category where subcategoryid=:subCatId", nativeQuery = true)
	  int deletebysubcatid(@Param("subCatId") int subId); 	

}
