package bean;
import model.Listing;import model.Location;import java.util.List;import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.persistence.Column;import dao.MainDAO;
@ManagedBean(name="main", eager=true)
@SessionScoped
public class MainBean {
  private String mainstr;  private String country;  private String locality;  private String route;  private String street_number;  private String postal_code;  private String out_str;    @ManagedProperty(value="#{mainDAO}")  private MainDAO mainDAO;  public void setMainstr(String mainstr) {	  this.mainstr = mainstr;  }  public String getMainstr() {	  return mainstr;  }  
  public void setCountry(String country) {
	  this.country = country;
  }
  public String getCountry() {
	  return country;
  }    public void setLocality(String locality) {	  this.locality = locality;  }  public String getLocality() {	  return locality;  }  public void setRoute(String route) {	  this.route = route;  }  public String getRoute() {	  return route;  }  public void setStreet_number(String street_number) {	  this.street_number = street_number;  }  public String getStreet_number() {	  return street_number;  }  public void setPostal_code(String postal_code) {	  this.postal_code = postal_code;  }  public String getPostal_code() {	  return postal_code;  }  public void setOut_str(String out_str) {	  this.out_str = out_str;  }  public String getOut_str() {	  return out_str;  }
  public void setMainDAO(MainDAO mainDAO) {	  this.mainDAO = mainDAO;  }	  public MainDAO getMainDAO() {	  return mainDAO;  }
  public String find_country() {	  //Location curr = mainDAO.find(country);	  out_str = mainstr;	  	  /*if (curr.getCountry() == null)			return "error";		else			return curr.getCountry();*/	  return "/index?faces-redirect=true";  }
} 
