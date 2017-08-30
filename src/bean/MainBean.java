package bean;
import model.Listing;import model.Location;import java.util.List;import java.text.SimpleDateFormat;import java.util.Date;import javax.faces.application.FacesMessage;import javax.faces.context.FacesContext;import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.persistence.Column;import dao.MainDAO;import org.primefaces.context.RequestContext;import org.primefaces.event.SelectEvent;
@ManagedBean(name="main", eager=true)
@SessionScoped
public class MainBean {
  private String mainstr;  private String country;  private String locality;  private String premise;  private String route;  private String street_number;  private String postal_code;  private String out_str;  private Date date_from;  private Date date_to;  private Date min_date_to;    @ManagedProperty(value="#{mainDAO}")  private MainDAO mainDAO;  public void setMainstr(String mainstr) {	  this.mainstr = mainstr;  }  public String getMainstr() {	  return mainstr;  }  
  public void setCountry(String country) {
	  this.country = country;
  }
  public String getCountry() {
	  return country;
  }    public void setLocality(String locality) {	  this.locality = locality;  }  public String getLocality() {	  return locality;  }    public void setPremise(String premise) {	  this.premise = premise;  }  public String getPremise() {	  return premise;  }  public void setRoute(String route) {	  this.route = route;  }  public String getRoute() {	  return route;  }  public void setStreet_number(String street_number) {	  this.street_number = street_number;  }  public String getStreet_number() {	  return street_number;  }  public void setPostal_code(String postal_code) {	  this.postal_code = postal_code;  }  public String getPostal_code() {	  return postal_code;  }    public void setOut_str(String out_str) {	  this.out_str = out_str;  }  public String getOut_str() {	  return out_str;  }  public void onDateSelect(SelectEvent event) {      FacesContext facesContext = FacesContext.getCurrentInstance();      SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");      facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Date Selected", format.format(event.getObject())));        }     public void click() {      RequestContext requestContext = RequestContext.getCurrentInstance();             requestContext.update("form:display");      requestContext.execute("PF('dlg').show()");  }    public void setDate_from(Date date_from) {	  this.date_from = date_from;  }  public Date getDate_from() {	  return date_from;  }    public void setDate_to(Date date_to) {	  this.date_to = date_to;  }  public Date getDate_to() {	  return date_to;  }    public void setMin_date_to(Date min_date_to) {	  this.min_date_to = min_date_to;  }  public Date getMin_Date_to() {	  return min_date_to;  }  
  public void setMainDAO(MainDAO mainDAO) {	  this.mainDAO = mainDAO;  }	  public MainDAO getMainDAO() {	  return mainDAO;  }
  public String find_country() {	  Location curr = mainDAO.find(country);	  out_str = curr.getCountry();	  	  /*if (curr.getCountry() == null)			return "error";		else			return curr.getCountry();*/	  return "/index?faces-redirect=true";  }
} 
