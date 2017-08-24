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
	
	public NavBean() {
		reg_edit = "Register";
		login_logout = "Logout";
		hellomessage = "";
	}
	
	public void setRed_edit(String reg_edit) {
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
	
	public String logoclick() {
		setHellomessage("yooos");
		return "html/register.xhtml";
	}
	
}
