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
		if(userExist(user)){
			return "Username Exists";
		}
		em.persist(user);
		return "well done";
	}
	
	public boolean userExist(user user){
		Query query = em.createQuery("from user");
		List<user> users = query.getResultList();
		for(int i=0; i<users.size(); i++){
			if(users.get(i).getUserName().equals(user.getUserName())){
				return true;
			}
		}
		return false;
	}

	@Override
	public String verifyUser(user user) {
		Query query = em.createQuery("from user");
		List<user> users = query.getResultList(); 
		for(int i=0; i<users.size(); i++){
			if(users.get(i).getUserName().equals(user.getUserName())){
				if(users.get(i).getUserPassword().equals(user.getUserPassword())){
					return "true";
				}
			}
		}
		return "false";
	}
}
