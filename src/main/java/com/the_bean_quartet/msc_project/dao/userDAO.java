package com.the_bean_quartet.msc_project.dao;

import java.util.Collection;

import javax.ejb.Local;

import com.the_bean_quartet.msc_project.entities.user;

@Local
public interface userDAO {
	Collection<user> getUserData();

	String addUser(user user);

}
