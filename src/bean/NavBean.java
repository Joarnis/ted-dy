package bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="nav")
@SessionScoped
public class NavBean {

	private String sign_edit;
	private String login_logout;
	private String hellomessage;
	
	public NavBean() {
		sign_edit = "Sign up";
		login_logout = "Logout";
		hellomessage = "";
	}
	
	public void setSign_edit(String sign_edit) {
		this.sign_edit = sign_edit;
	}
	
	public String getSign_edit(){
		return sign_edit;
	}
	
	public void setLogin_logout(String login_logout) {
		this.login_logout = login_logout;
	}
	
	public String getLogin_logout() {
		return login_logout;
	}
	
	public void setHellomessage(String name) {
		this.hellomessage = "Welcome" + name + "!";
	}
	
	public void emptyHellomessage() {
		this.hellomessage = "";
	}
	
	public String getHellomessage() {
		return hellomessage;
	}
	
}
