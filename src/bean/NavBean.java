package bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="nav")
@SessionScoped
public class NavBean {

	private String reg_edit;
	private String login_logout;
	private String hellomessage;
	private String login_visibility;
	
	public NavBean() {
		reg_edit = "Register";
		login_logout = "Login";
		hellomessage = "";
		login_visibility = "none";
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
	
	public void setLogin_visibility(String visibility) {
		this.login_visibility = visibility;
	}
	
	public String getLogin_visibility() {
		return login_visibility;
	}
	
	public String logoclick() {
		setReg_edit("NE");
		return "/index";
	}
	
	public String login_logout_clicked() {
		if (login_logout.equals("Login")){
			/*no one is logged in*/
			return "html/login?faces-redirect=true";
		}
		else {
			
		}
		
		return "/index?faces-redirect=true";
	}
	
	public String login() {
		/*do necessary actions*/
		login_logout = "Logout";
		return "/index?faces-redirect=true";
	}
	
}
