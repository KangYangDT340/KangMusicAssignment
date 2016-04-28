package com.the_bean_quartet.msc_project.services;

import java.util.Collection;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import com.the_bean_quartet.msc_project.dao.userDAO;
import com.the_bean_quartet.msc_project.entities.user;

@Stateless
@Local
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class userServiceEJB implements userService{
	
	@Inject 
	private userDAO userDAO;
	public Collection<user> getUserDataset()
	{
		return userDAO.getUserData();

	}
	@Override
	public String addUser(user user) {
		// TODO Auto-generated method stub
		return userDAO.addUser(user);
	}
	@Override
	public String verifyUser(user user) {
		// TODO Auto-generated method stub
		return userDAO.verifyUser(user);
	}

}
