package bean;

import model.Listing;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.persistence.Column;

@ManagedBean(name="main_search")
@SessionScoped
public class MainSearchBean {

  private String search_str;
  
  public void set_search_str(String input_str) {
    this.search_str = input_str;
  }
  
  public String get_search_str() {
    return search_str;
  }
  
  
} 
