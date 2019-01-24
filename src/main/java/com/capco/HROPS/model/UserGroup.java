package com.capco.HROPS.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "User_Group")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "createdAt" }, allowGetters = true)
public class UserGroup {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "usergroupid")
	private int userGroupId;

	@Column(name = "usergroupname")
	private String userGroupName;

	@Column(name = "usergrpcode")
	private String userGroupCode;

	@Column(nullable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date createdAt;

	public UserGroup(int userGroupId, String userGroupName, String userGroupCode, Date createdAt) {
		super();
		this.userGroupId = userGroupId;
		this.userGroupName = userGroupName;
		this.userGroupCode = userGroupCode;
		this.createdAt = createdAt;
	}

	public UserGroup() {
		super();
	}

	public int getUserGroupId() {
		return userGroupId;
	}

	public void setUserGroupId(int userGroupId) {
		this.userGroupId = userGroupId;
	}

	public String getUserGroupName() {
		return userGroupName;
	}

	public void setUserGroupName(String userGroupName) {
		this.userGroupName = userGroupName;
	}

	public String getUserGroupCode() {
		return userGroupCode;
	}

	public void setUserGroupCode(String userGroupCode) {
		this.userGroupCode = userGroupCode;
	}

	public Date getCre() {
		return createdAt;
	}

	public void setCre(Date createdAt) {
		this.createdAt = createdAt;
	}

}
