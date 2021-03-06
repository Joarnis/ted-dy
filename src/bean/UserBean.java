package bean;

import model.User;
import dao.UserDAO;
import javax.faces.validator.ValidatorException;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.application.FacesMessage;
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
	private boolean isHost;
	private byte isVerified;
	private String lastName;
	private String password;
	private String phoneNum;
	private String username;
	
	private User current;
	
	@ManagedProperty(value="#{userDAO}")
    private UserDAO userDAO;
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setIsHost(boolean isHost) {
		this.isHost = isHost;
	}
	
	public boolean getIsHost() {
		return isHost;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPassword() {
		return password;
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
		User user = new User();

		user.setFirstName(firstName);
		user.setEmail(email);
		user.setIsHost((byte)(isHost ? 1:0));
		user.setIsVerified((byte)0);
		user.setLastName(lastName);
		user.setPhoneNum(phoneNum);
		user.setUsername(username);
		//compute hash
		String passhash = DigestUtils.sha512Hex(password);
		user.setPasshash(passhash);
		//dao goes here
		return userDAO.insertUser(user);
	}
	
	public String editUser() {
		User user = new User();
		
		user.setId(id);
		user.setFirstName(firstName);
		user.setEmail(email);
		user.setIsHost((byte)(isHost ? 1:0));
		user.setIsVerified(isVerified);
		user.setLastName(lastName);
		user.setPhoneNum(phoneNum);
		user.setUsername(username);
		//compute hash
		String passhash = DigestUtils.sha512Hex(password);
		user.setPasshash(passhash);
		return userDAO.editUser(user);
	}
	
	public String loginUser() {
		//compute hash
		String passhash = DigestUtils.sha512Hex(password);
		current = userDAO.find(username, passhash);
		if (current == null)
			return "error";
		else
			return "ok";
	}
	
	public boolean isLoggedIn() {
        return current != null;
    } 
	
	/*these methods are for the actual user logged in*/
	public String real_username()
	{
		return current.getFirstName();
	}
	
	public void validate_username(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		boolean existing = userDAO.find((String)value);
		if (isLoggedIn())
			existing = existing && !((String)value).equals(current.getUsername());
		
		String msg = "Username already exists";
		if (existing == true) {
			throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg));
		}
	}
	
	public void populate_from_current() {
		id = current.getId();
		email = current.getEmail();
		firstName = current.getFirstName();
		isHost = current.getIsHost()==1 ? true : false;
		isVerified = current.getIsVerified();
		lastName = current.getLastName();
		phoneNum = current.getPhoneNum();
		username = current.getUsername();
	}
}
