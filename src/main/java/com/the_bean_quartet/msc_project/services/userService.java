package com.the_bean_quartet.msc_project.services;

import java.util.Collection;

import javax.ejb.Local;

import com.the_bean_quartet.msc_project.entities.user;

@Local
public interface userService {
	public Collection<user> getUserDataset();

	public String addUser(user user);

}
