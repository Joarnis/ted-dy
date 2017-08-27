package bean;

import model.User;
import dao.UserDAO;
import javax.faces.context.FacesContext;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.persistence.Column;
import org.apache.commons.codec.digest.DigestUtils;

@ManagedBean(name="user", eager=true)
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
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	
	public String getPhoneNum() {
		return phoneNum;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
    public UserDAO getUserDAO() {
		return userDAO;
	}
	
	public String registerUser()
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
		//compute hash
		//dao goes here
		String message = userDAO.insertUser(user);
		return message;
	}
	
	public String login() {
		//compute hash
		String passhash = DigestUtils.sha512Hex(password);
		current = userDAO.find(username, passhash);
		if (current == null)
			return "error";
		else
			return "ok";
	}
	
	public String logout() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/index?faces-redirect=true";
	}
	
	public boolean isLoggedIn() {
        return current != null;
    } 
	
	/*these methods are for the actual user logged in*/
	public String real_username()
	{
		return current.getUsername();
	}
}
