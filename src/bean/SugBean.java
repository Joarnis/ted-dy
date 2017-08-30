package bean;
import model.Listing;import model.Location;import bean.NavBean;import java.util.List;import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.persistence.Column;import dao.MainDAO;import dao.SugDAO;
@ManagedBean(name="sug", eager=true)
@SessionScoped
public class SugBean {
  private String out;    @ManagedProperty(value="#{sugDAO}")  private SugDAO sugDAO;  public void setOut(String out) {	  this.out = out;  }  public String getOut() {	  return out;  }
  public void setSugDAO(SugDAO sugDAO) {	  this.sugDAO = sugDAO;  }	  public SugDAO getSugDAO() {	  return sugDAO;  }  //login page
  public void find_suggestions() {	  return ;  }  //index page  public void find_top_rated_rooms() {	  //out = sugDAO.find_top();	  return ;  }  
} 
