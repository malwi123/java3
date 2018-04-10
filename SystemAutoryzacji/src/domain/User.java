package domain;

public class User 
{
	private String username;
	private String email;
	private String password;
	private UserType userType = UserType.anonymus;
	
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public UserType getUserType() {
		return userType;
	}
	public void setUserType(UserType userType) {
		this.userType = userType;
	}
	
	public Boolean IsPrivilaged()
	{
		if(this.userType==UserType.privilaged || this.userType==UserType.admin)
			return true;
		
		return false;
	
	}
	
	public Boolean IsAdmin()
	{
		if( this.userType==UserType.admin)
			return true;
		
		return false;
	
	}
	

}
