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
	
/*	public NavBean() {
		reg_edit = "Register";
		login_logout = "Login";
		hellomessage = "";
	}*/
	
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
	
	public String login_logout_clicked() {
		if (login_logout.equals("Login")){
			/*no one is logged in*/
			return "html/login?faces-redirect=true";
		}
		else {
			//logout
		}
		
		return "/index?faces-redirect=true";
	}
	
	public String login() {
		
		FacesContext context = FacesContext.getCurrentInstance();
		/*pass control to user bean for login*/
		String status = user.login();
		String statusc = "ok";
		/*check if login was successful to alter the HTML*/
		if (status.equals("ok")){
			login_logout = "Logout";
			reg_edit = "Edit profile";
			this.setHellomessage("kon");
		}
		else {
			String error = "Invalid username/password";
			context.addMessage(null, new FacesMessage(error));
		}
		return "/index?faces-redirect=true";
	}
	
}
