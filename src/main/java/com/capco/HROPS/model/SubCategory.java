package com.capco.HROPS.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Sub_Category")
public class SubCategory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Integer subcategoryid;

	private String subcategoryname;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "category_id")
	@JsonIgnore
	private Category category;

	public Integer getSubcategoryid() {
		return subcategoryid;
	}

	public void setSubcategoryid(Integer subcategoryid) {
		this.subcategoryid = subcategoryid;
	}

	public String getSubcategoryname() {
		return subcategoryname;
	}

	public void setSubcategoryname(String subcategoryname) {
		this.subcategoryname = subcategoryname;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	

	@Override
	public String toString() {
		return "SubCategory [subcategoryid=" + subcategoryid + ", subcategoryname=" + subcategoryname + ", category="
				+ category + "]";
	}

	public SubCategory(Integer subcategoryid, String subcategoryname, Category category) {
		super();
		this.subcategoryid = subcategoryid;
		this.subcategoryname = subcategoryname;
		this.category = category;
	}

	public SubCategory() {
		super();
	}

	

}
