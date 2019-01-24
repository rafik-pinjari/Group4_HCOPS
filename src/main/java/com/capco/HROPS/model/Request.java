package com.capco.HROPS.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "request")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt"},
ignoreUnknown = true)
public class Request {
	
	@Id 
	//@GeneratedValue
	 @GeneratedValue(strategy =GenerationType.IDENTITY)
	private int id;
	
	
	private String description;
	
	 @Column(nullable = false, updatable = false)
     @Temporal(TemporalType.TIMESTAMP)
     @CreatedDate
     private Date createdAt;

//     @Column(nullable = false)
//     @Temporal(TemporalType.TIMESTAMP)
//     @LastModifiedDate
//     private Date updatedAt;
	
	   @ManyToOne(cascade= CascadeType.ALL)
	    @JoinColumn(name = "incidentId")
	   @JsonIgnore
	    private Incident incident1;

	public Request() {
		super();
	}

	public Request( String description, Incident incident1) {
		super();
	//	this.id = id;
		this.description = description;
		this.incident1 = incident1;
	}

//	public int getId() {
//		return id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Incident getIncident1() {
		return incident1;
	}

	public void setIncident1(Incident incident1) {
		this.incident1 = incident1;
	}
	 public Date getCreatedAt() {
	        return createdAt;
	    }

	    public void setCreatedAt(Date createdAt) {
	        this.createdAt = createdAt;
	    }

		@Override
		public String toString() {
			return " description=" + description + ", createdAt=" + createdAt + ", incident1="
					+ incident1 + "]";
		}

//	    public Date getUpdatedAt() {
//	        return updatedAt;
//	    }
//
//	    public void setUpdatedAt(Date updatedAt) {
//	        this.updatedAt = updatedAt;
//	    }
	    
}
