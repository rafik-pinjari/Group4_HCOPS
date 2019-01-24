package com.capco.HROPS.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Category")
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Integer categoryid;

	private String categoryName;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "category", cascade = CascadeType.ALL)
	private List<SubCategory> subcategory;

	public Integer getId() {
		return categoryid;
	}

	public void setId(Integer categoryid) {
		this.categoryid = categoryid;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public List<SubCategory> getSubcategory() {
		return subcategory;
	}

	public void setSubcategory(List<SubCategory> subcategory) {
		this.subcategory = subcategory;
	}

	public Category(Integer categoryid, String categoryName, List<SubCategory> subcategory) {
		super();
		this.categoryid = categoryid;
		this.categoryName = categoryName;
		this.subcategory = subcategory;
	}

	public Category() {
		super();
	}

	@Override
	public String toString() {
		return "Category [categoryid=" + categoryid + ", categoryName=" + categoryName + ", subcategory=" + subcategory
				+ "]";
	}

}
