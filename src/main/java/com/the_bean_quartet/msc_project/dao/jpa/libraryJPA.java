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

import com.the_bean_quartet.msc_project.dao.libraryDAO;
import com.the_bean_quartet.msc_project.entities.library;
import com.the_bean_quartet.msc_project.entities.track;

@Stateless
@Local
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class libraryJPA implements libraryDAO {
	@PersistenceContext
	private EntityManager em;
	
	public Collection<library> getLibraryData() {
		Query query = em.createQuery("from library");
		List<library> bData = query.getResultList(); 
		return bData;
	}

	@Override
	public void addLibrary(library library) {
			System.out.println("Adding library is started");

			
				em.merge(library);
			

			System.out.println("Adding library is done");

		}
	
}
