package com.capco.HROPS.vio;

public class UserVio {
	private String userid;

    private String password;
    
    private String username;
    
    private String email;
        
 
    private String usergroup;
    
    private String location;
   
    private String cityName;

	
	private String stateName;


	private String countryName;

    private String profilePic;
    
    private int activity;
    
    private String department;


	

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


	public String getCityName() {
		return cityName;
	}


	public void setCityName(String cityName) {
		this.cityName = cityName;
	}


	public String getStateName() {
		return stateName;
	}


	public void setStateName(String stateName) {
		this.stateName = stateName;
	}


	public String getCountryName() {
		return countryName;
	}


	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}


	@Override
	public String toString() {
		return "uservio [userid=" + userid + ", password=" + password + ", username=" + username + ", email=" + email
				+ ", usergroup=" + usergroup + ", location=" + location + ", profilePic=" + profilePic + ", activity="
				+ activity + ", department=" + department + ", cityName=" + cityName + ", stateName=" + stateName
				+ ", countryName=" + countryName + "]";
	}


	public UserVio(String userid, String password, String username, String email, String usergroup, String location,
			String profilePic, int activity, String department, String cityName, String stateName, String countryName) {
		super();
		this.userid = userid;
		this.password = password;
		this.username = username;
		this.email = email;
		this.usergroup = usergroup;
		this.location = location;
		this.profilePic = profilePic;
		this.activity = activity;
		this.department = department;
		this.cityName = cityName;
		this.stateName = stateName;
		this.countryName = countryName;
	}


	public UserVio() {
		super();
	}
	
	

}
