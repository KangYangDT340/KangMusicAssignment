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

import com.the_bean_quartet.msc_project.dao.DAO;
import com.the_bean_quartet.msc_project.entities.library;

@Stateless
@Local
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class JPA implements DAO {
	@PersistenceContext
	private EntityManager em;
	
	public Collection<library> getLibraryData() {
		Query query = em.createQuery("from library");
		List<library> bData = query.getResultList(); 
		return bData;
	}
}
