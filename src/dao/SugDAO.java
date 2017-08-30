package dao;

import java.util.List;
import model.Location;
import model.Listing;
import model.Review;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import dao.JPAResourceBean;

@ManagedBean(name="sugDAO", eager=true)
@SessionScoped
public class SugDAO {

	@ManagedProperty(value="#{jpaResourceBean}")
	protected JPAResourceBean jpaResourceBean;

	public void setJpaResourceBean(JPAResourceBean jpaResourceBean) {
		this.jpaResourceBean = jpaResourceBean;
	}

	public JPAResourceBean getJpaResourceBean() {
		return jpaResourceBean;
	}

	//@SuppressWarnings("unchecked")
	public String find_top() {
	
		EntityManager em = jpaResourceBean.getEMF().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		Query q = em.createQuery("select a from Listing a where a.overallRating > 4 order by a.overallRating desc");
		List<Listing> rooms = q.getResultList();
		tx.commit();
		em.close();
		
		
		return "nothing";
	}
}
