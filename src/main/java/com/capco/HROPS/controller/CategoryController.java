package com.capco.HROPS.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.capco.HROPS.model.Category;
import com.capco.HROPS.model.SubCategory;
import com.capco.HROPS.model.User;
import com.capco.HROPS.repository.CategoryRepository;
import com.capco.HROPS.repository.SubCategoryRepository;

@RestController
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	CategoryRepository categoryRepository;
	@Autowired
	SubCategoryRepository subCategoryRepository;


	@CrossOrigin
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/save", method = RequestMethod.POST, headers = "Accept=application/json", produces = {"application/json"})
	public ResponseEntity<User> user(@RequestBody Category category, HttpServletRequest request, HttpServletResponse response)
	{
		SubCategory subCategory;

		String catname = category.getCategoryName();


		Category dbcat = categoryRepository.findBycategoryName(catname);
		List<SubCategory> list2;
		String subcategoryname = null;
		list2 = category.getSubcategory();
		for (SubCategory d : list2) {
			subcategoryname = d.getSubcategoryname();
		}
		System.out.println("subcategory name: " + subcategoryname);
		subCategory = subCategoryRepository.findBysubcategoryname(subcategoryname);
		if (subCategory == null) {
			if(dbcat!=null)
			{
				List<SubCategory> list;
				String subcatname = null;
				list = category.getSubcategory();
				System.out.println("id1  :");

				for (SubCategory d : list) {

					subcatname = d.getSubcategoryname();
				}	
				int catId=dbcat.getId();
			subCategoryRepository.saveSubCat(subcatname,catId);
		
			return new ResponseEntity(" subcategory save", HttpStatus.OK);
			}
			else
			{	
			System.out.println("not present");
			List<SubCategory> list;
			String subcatname = null;
			list = category.getSubcategory();
			System.out.println("id1  :");

			for (SubCategory d : list) {

				subcatname = d.getSubcategoryname();
			}
			categoryRepository.save(category);
	int cateId=categoryRepository.getid();
	int subCatId=subCategoryRepository.getid();
	subCategoryRepository.updateSub(subCatId, cateId);

	return new ResponseEntity(" category subcategory save", HttpStatus.OK);
			}
		
		} else {

			return new ResponseEntity("subcategory already exists", HttpStatus.ALREADY_REPORTED);
		}

	}

	@RequestMapping(value = "/deletebycategoryid /{categoryid}", method = RequestMethod.DELETE)
	public void deleteCategory(@PathVariable Integer categoryid) {

		categoryRepository.deleteById(categoryid);
	}

	@RequestMapping(value = "/getBycategoryId/{categoryid}", method = RequestMethod.GET)
	public List<Category> getBycategoryid(@PathVariable Integer categoryid) {

		return categoryRepository.findBycategoryid(categoryid);

	}

	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public List<Category> getAll() {

		return categoryRepository.findAll();

	}
	@RequestMapping(value = "/deletebysubcategory/{subcategoryid}", method = RequestMethod.DELETE)
	public void deletesubCategory(@PathVariable Integer subcategoryid) {
		
	//	subCategoryRepository.deleteById(subcategoryid);
		subCategoryRepository.deletebysubcatid(subcategoryid);

		//categoryRepository.deleteById(subcategoryid);
	}

}
