package com.capco.HROPS.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "incident")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt"},
        ignoreUnknown = true)
public class Incident {
	
	@Column(name="id")
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Id
	@Column(name="incidentId")
	private String incidentId;
  
		  	@NotBlank
		    private String requestor;
		  	
		  	@NotBlank
		    private String userId;
		  	
		  	private String status;
		  	
		  	@NotBlank
		  	private String location;
		  	
		  	@NotBlank
		  	private String category;
		  	
		  	@NotBlank
		  	private String subcategory;
		  	
		  	private String fileName;
		  	
		  	 @Column(nullable = false, updatable = false)
		     @Temporal(TemporalType.TIMESTAMP)
		     @CreatedDate
		     private Date createdAt;
		  	
		  	
		  	@OneToMany(fetch = FetchType.EAGER,mappedBy="incident1",cascade = CascadeType.ALL)
		    private List<Request> request;
	
		  	public Incident(int id, String incidentId, @NotBlank String requestor, @NotBlank String userId, String status,
			@NotBlank String location, @NotBlank String category, @NotBlank String subcategory, Date createdAt,
			List<Request> request,String fileName) {
		super();
		this.id = id;
		this.incidentId = incidentId;
		this.requestor = requestor;
		this.userId = userId;
		this.status = status;
		this.location = location;
		this.category = category;
		this.subcategory = subcategory;
		this.createdAt = createdAt;
		this.request = request;
		this.fileName=fileName;
	}
	
	public Incident() {
		super();
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getIncidentId() {
		return incidentId;
	}
	
	public void setIncidentId(String incidentId) {
		this.incidentId = incidentId;
	}
	
	public String getRequestor() {
		return requestor;
	}
	
	public void setRequestor(String requestor) {
		this.requestor = requestor;
	}
	
	public String getUserId() {
		return userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getLocation() {
		return location;
	}
	
	public void setLocation(String location) {
		this.location = location;
	}
	
	public String getCategory() {
		return category;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}
	
	public String getSubcategory() {
		return subcategory;
	}
	
	public void setSubcategory(String subcategory) {
		this.subcategory = subcategory;
	}
	
	public Date getCreatedAt() {
		return createdAt;
	}
	
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
	public List<Request> getRequest() {
		return request;
	}
	
	public void setRequest(List<Request> request) {
		this.request = request;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public String toString() {
		return "Incident1 [id=" + id + ", incidentId=" + incidentId + ", caller=" + requestor + ", userId=" + userId
				+ ", status=" + status + ", location=" + location + ", category=" + category + ", subcategory="
				+ subcategory + ", fileName=" + fileName + ", createdAt=" + createdAt + ", request=" + request + "]";
	}

	
		
}
