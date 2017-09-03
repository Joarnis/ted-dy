package bean;

import bean.UserBean;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="nav", eager=true)
@SessionScoped
public class NavBean {

	private String reg_edit;
	private String login_logout;
	private String hellomessage;
	
	@ManagedProperty(value="#{user}")
	private UserBean user;
	
	@PostConstruct
	public void init() {
		reg_edit = "Register";
		login_logout = "Login";
		hellomessage = "";
	}
	
	public void setReg_edit(String reg_edit) {
		this.reg_edit = reg_edit;
	}
	
	public String getReg_edit(){
		return reg_edit;
	}
	
	public void setLogin_logout(String login_logout) {
		this.login_logout = login_logout;
	}
	
	public String getLogin_logout() {
		return login_logout;
	}
	
	public void setHellomessage(String name) {
		this.hellomessage = "Welcome " + name + "!";
	}
	
	public void emptyHellomessage() {
		this.hellomessage = "";
	}
	
	public String getHellomessage() {
		return hellomessage;
	}
	
	public void setUser(UserBean user) {
		this.user = user;
	}
	
	public UserBean getUser() {
		return user;
	}

	/*the 2 methods below determine the behavior when the buttons are clicked*/
	public String reg_edit_clicked() {
		if (reg_edit.equals("Register")){
			return "html/register?faces-redirect=true";
		}
		else {
			//edit profile
			return "";
		}
	}

	public String login_logout_clicked() {
		if (login_logout.equals("Login")){
			/*no one is logged in -> login*/
			return "html/login?faces-redirect=true";
		}
		else {
			logout();
			return "/index?faces-redirect=true";
		}
		
	}
	
	/*the methods below determine the behavior when a login/register form is submitted*/
	public String register() {
		FacesContext context = FacesContext.getCurrentInstance();
		/*pass control to user bean for login*/
		//for the time being registration is inactive
		String status = user.registerUser();
		
		/*check if insert was successful to proceed*/
		if (status.equals("ok")) {
		}
		else
		{
		}
		return "/index?faces-redirect=true";
	}
	
	
	public String login() {	
		FacesContext context = FacesContext.getCurrentInstance();
		/*pass control to user bean for login*/
		String status = user.loginUser();
		
		/*check if login was successful to proceed*/
		if (status.equals("ok")){
			login_logout = "Logout";
			reg_edit = "Edit profile";
			setHellomessage(user.real_username());
		}
		else {
			String error = "Invalid username/password";
			context.addMessage(null, new FacesMessage(error));
		}
		return "/index?faces-redirect=true";
	}
	
	//this method is invoked directly from the login_logout button
	public void logout() {
		user.logoutUser();	//session is invalidated here
		login_logout = "Login";
		reg_edit = "Register";
		emptyHellomessage();
	}
	
}
