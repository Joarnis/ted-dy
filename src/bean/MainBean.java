package bean;

import model.Listing;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.persistence.Column;

@ManagedBean(name="main", eager=true)
@SessionScoped
public class MainBean {
  private String search_str;
  public void setSearch_str(String input_str) {
	  this.search_str = input_str;
  }
  public String getSearch_str() {
	  return search_str;
  }
  public void setMainDAO(MainDAO mainDAO) {
  public String find_country() {
}