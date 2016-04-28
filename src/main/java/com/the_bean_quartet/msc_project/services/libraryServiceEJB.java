package com.the_bean_quartet.msc_project.services;

import java.util.Collection;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import com.the_bean_quartet.msc_project.dao.libraryDAO;
import com.the_bean_quartet.msc_project.entities.library;
import com.the_bean_quartet.msc_project.entities.track;


@Stateless
@Local
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class libraryServiceEJB implements libraryService{

	
	@Inject 
	private libraryDAO libraryDAO;
	

	public Collection<library> getLibraryDataset() {
		// TODO Auto-generated method stub
		return libraryDAO.getLibraryData();
	}


	@Override
	public void addLibrary(library library) {
		System.out.println("libraryServiceEJB111111111111111111111");

		libraryDAO.addLibrary(library);
	}
}
