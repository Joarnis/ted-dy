package bean;

import model.User;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.persistence.Column;

@ManagedBean(name="user")
@SessionScoped
public class UserBean {
	
	private int id;
	private String email;
	private String firstName;
	private byte isHost;
	private byte isVerified;
	private String lastName;
	private String passhash;
	private String phoneNum;
	private String username;
	
	private User current;
	
	public void registerUser()
	{
		User user = new User();

		user.setFirstName(firstName);
		user.setEmail(email);
		user.setIsHost(isHost);
		user.setIsVerified(isVerified);
		user.setLastName(lastName);
		user.setPhoneNum(phoneNum);
		user.setUsername(username);
		//dao goes here
	
	}
	
	public boolean isLoggedIn() {
        return current != null;
    } 
	
	public String getTest(){
		return test;
	}

}
