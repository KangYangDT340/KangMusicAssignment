package com.the_bean_quartet.msc_project.services;

import java.util.Collection;

import javax.ejb.Local;

import com.the_bean_quartet.msc_project.entities.library;
import com.the_bean_quartet.msc_project.entities.user;


@Local
public interface IpodService {
	public Collection<library> getLibraryDataset();
	public Collection<user> getUserDataset();

	
}
