package dao;

import java.util.List;
import model.Location;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import dao.JPAResourceBean;

@ManagedBean(name="mainDAO", eager=true)
@SessionScoped
public class MainDAO {

	@ManagedProperty(value="#{jpaResourceBean}")
	protected JPAResourceBean jpaResourceBean;

	public void setJpaResourceBean(JPAResourceBean jpaResourceBean) {
		this.jpaResourceBean = jpaResourceBean;
	}

	public JPAResourceBean getJpaResourceBean() {
		return jpaResourceBean;
	}

	//@SuppressWarnings("unchecked")
	public Location find(String country) {
		EntityManager em = jpaResourceBean.getEMF().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		Query q = em.createQuery("Select u from Location u where u.country = :country");
		q.setParameter("country", country);
		List<Location> locations = q.getResultList();
		tx.commit();
		em.close();
		//LOGGER.info("Currently executing method foo()");
		Location loc = locations.get(0);
		return loc;

	}
}
