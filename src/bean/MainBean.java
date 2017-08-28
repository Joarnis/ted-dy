package bean;

import model.Listing;import model.Location;import java.util.List;import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.persistence.Column;import dao.MainDAO;

@ManagedBean(name="main", eager=true)
@SessionScoped
public class MainBean {
  private String search_str;  private String out_str;    @ManagedProperty(value="#{mainDAO}")  private MainDAO mainDAO;
  public void setSearch_str(String input_str) {
	  this.search_str = input_str;
  }
  public String getSearch_str() {
	  return search_str;
  }    public void setOut_str(String input_str) {	  this.out_str = input_str;  }  public String getOut_str() {	  return out_str;  }
  public void setMainDAO(MainDAO mainDAO) {	  this.mainDAO = mainDAO;  }	  public MainDAO getMainDAO() {	  return mainDAO;  }
  public String find_country() {	  //Location curr = mainDAO.find(search_str);	  out_str = search_str;	  /*if (curr.getCountry() == null)			return "error";		else			return curr.getCountry();*/	  return "/index?faces-redirect=true";  }
} 
