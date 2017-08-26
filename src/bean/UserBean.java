package bean;

import model.User;
import dao.UserDAO;
import javax.faces.context.FacesContext;
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
	private String password;
	private String phoneNum;
	private String username;
	
	private User current;
	
	@ManagedProperty(value="#{userDAO}")
    private UserDAO userDAO;
	
	public void registerUser()
	{
		FacesContext context = FacesContext.getCurrentInstance();
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
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPassword() {
		return this.password;
	}
}
