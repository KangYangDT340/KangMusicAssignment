package com.the_bean_quartet.msc_project.dao.jpa;

import java.util.Collection;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.the_bean_quartet.msc_project.dao.userDAO;
import com.the_bean_quartet.msc_project.entities.user;

@Stateless
@Local
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class userJPA implements userDAO {
	@PersistenceContext
	private EntityManager em;
	
	public Collection<user> getUserData() {
		Query query = em.createQuery("from user");
		List<user> bData = query.getResultList(); 
		return bData;
	}

	@Override
	public String addUser(user user) {
		// TODO Auto-generated method stub
		em.persist(user);
		return "well done";
	}
}
