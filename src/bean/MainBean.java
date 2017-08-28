package bean;

import model.Listing;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.persistence.Column;

@ManagedBean(name="main_search", eager=true)
@SessionScoped
public class MainSearchBean {

  private String search_str;
  public void setSearch_str(String input_str) {
    this.search_str = input_str;
  }
  public String getSearch_str() {
    return search_str;
  }
  
  
} 
