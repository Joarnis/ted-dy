package bean;
import model.Listing;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.persistence.Column;
@ManagedBean(name="sug", eager=true)
@SessionScoped
public class SugBean {
  private String out;
  public void setSugDAO(SugDAO sugDAO) {
  public void find_suggestions() {
}