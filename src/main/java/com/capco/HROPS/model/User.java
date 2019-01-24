package com.capco.HROPS.model;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "User")
@EntityListeners(AuditingEntityListener.class)
public class User {
	
	   
	    private int id;

	    @Id
	    @NotNull
	    private String userid;

	    private String password;
	    
	    private String username;
	    
	    private String email;
	        
	 
	    private String usergroup;
	    
	    private String location;
	   
	    private String profilePic;
	    
	    private int activity;
	    
	    private String department;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getUserid() {
			return userid;
		}

		public void setUserid(String userid) {
			this.userid = userid;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getUsergroup() {
			return usergroup;
		}

		public void setUsergroup(String usergroup) {
			this.usergroup = usergroup;
		}

		public String getLocation() {
			return location;
		}

		public void setLocation(String location) {
			this.location = location;
		}

		public String getProfilePic() {
			return profilePic;
		}

		public void setProfilePic(String profilePic) {
			this.profilePic = profilePic;
		}

		public int getActivity() {
			return activity;
		}

		public void setActivity(int activity) {
			this.activity = activity;
		}

		public String getDepartment() {
			return department;
		}

		public void setDepartment(String department) {
			this.department = department;
		}

		@Override
		public String toString() {
			return "User [id=" + id + ", userid=" + userid + ", password=" + password + ", username=" + username
					+ ", email=" + email + ", usergroup=" + usergroup + ", location=" + location + ", profilePic="
					+ profilePic + ", activity=" + activity + ", department=" + department + "]";
		}

		public User(int id, @NotNull String userid, String password, String username, String email, String usergroup,
				String location, String profilePic, int activity, String department) {
			super();
			this.id = id;
			this.userid = userid;
			this.password = password;
			this.username = username;
			this.email = email;
			this.usergroup = usergroup;
			this.location = location;
			this.profilePic = profilePic;
			this.activity = activity;
			this.department = department;
		}

		public User() {
			super();
		}

		

	
}

