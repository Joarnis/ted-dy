package dao;

import java.util.List;
import model.User;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import dao.JPAResourceBean;

@ManagedBean(name="userDAO", eager=true)
@SessionScoped
public class UserDAO {

	@ManagedProperty(value="#{jpaResourceBean}")
	protected JPAResourceBean jpaResourceBean;
	
	public void setJpaResourceBean(JPAResourceBean jpaResourceBean) {
		this.jpaResourceBean = jpaResourceBean;
	}

	public JPAResourceBean getJpaResourceBean() {
		return jpaResourceBean;
	}
	
	public String insertUser(User user) {
		String retMessage;
		EntityManager em = jpaResourceBean.getEMF().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		try {
			em.persist(user);
			tx.commit();
			retMessage = "ok";
			return retMessage;
		} catch (PersistenceException e) {
			if (tx.isActive())
				tx.rollback();
			retMessage = e.getMessage();
			return retMessage;
		} finally {
			em.close();
		}
	}
	
	public String editUser(User user) {
		deleteUser(user.getId());
		String status = insertUser(user);
		return status;
	}
	
	public void deleteUser(int id) {
		EntityManager em = jpaResourceBean.getEMF().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		Query q = em.createQuery("Delete from User u where u.id = :id");
		q.setParameter("id", id);
		q.executeUpdate();
		tx.commit();
		em.close();
	}
	
	@SuppressWarnings("unchecked")
	public User find(String username, String passhash) {
		User user = null;

		EntityManager em = jpaResourceBean.getEMF().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		Query q = em.createQuery("Select u from User u where u.username = :username and u.passhash = :passhash");
		q.setParameter("username", username);
		q.setParameter("passhash", passhash);
		List<User> users = q.getResultList();
		tx.commit();
		em.close();

		if (users != null && users.size() == 1) {
			user = users.get(0);
		}

		return user;
	}
	
	@SuppressWarnings("unchecked")
	public boolean find(String username) {
		
		EntityManager em = jpaResourceBean.getEMF().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		Query q = em.createQuery("Select u from User u where u.username = :username");
		q.setParameter("username", username);
		List<User> users = q.getResultList();
		tx.commit();
		em.close();
		if (users != null && users.size() != 0)
			return true;
		return false;
	}
}
