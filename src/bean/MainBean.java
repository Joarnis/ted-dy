package bean;

import model.Listing;import model.Location;import java.util.List;import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.persistence.Column;import dao.MainDAO;

@ManagedBean(name="main", eager=true)
@SessionScoped
public class MainBean {
  private String country;  private String out_str;    @ManagedProperty(value="#{mainDAO}")  private MainDAO mainDAO;
  public void setCountry(String country) {
	  this.country = country;
  }
  public String getCountry() {
	  return country;
  }    public void setOut_str(String out_str) {	  this.out_str = out_str;  }  public String getOut_str() {	  return out_str;  }
  public void setMainDAO(MainDAO mainDAO) {	  this.mainDAO = mainDAO;  }	  public MainDAO getMainDAO() {	  return mainDAO;  }
  public String find_country() {	  Location curr = mainDAO.find(country);	  out_str = curr.getCountry() + "  xaxaxaxa   " + curr.getStreet();	  /*if (curr.getCountry() == null)			return "error";		else			return curr.getCountry();*/	  return "/index?faces-redirect=true";  }
} 
