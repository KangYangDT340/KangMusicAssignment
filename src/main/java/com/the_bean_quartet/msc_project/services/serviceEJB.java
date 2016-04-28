package com.the_bean_quartet.msc_project.services;

import java.util.Collection;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import com.the_bean_quartet.msc_project.dao.DAO;
import com.the_bean_quartet.msc_project.dao.userDAO;
import com.the_bean_quartet.msc_project.entities.library;
import com.the_bean_quartet.msc_project.entities.user;


@Stateless
@Local
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class serviceEJB implements IpodService{
	
	@Inject // uses reflection
	private DAO DAO;
	
	@Inject 
	private userDAO userDAO;
	
	public void setDao(DAO dao) {
		// do something really important on injection
		this.DAO = dao;
	}
	public Collection<library> getLibraryDataset(){
		return DAO.getLibraryData();
	}
	public Collection<user> getUserDataset() {
		// TODO Auto-generated method stub
		return userDAO.getUserData();
	}
}
