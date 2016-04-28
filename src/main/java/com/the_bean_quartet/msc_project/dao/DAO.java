package com.the_bean_quartet.msc_project.dao;

import java.util.Collection;

import javax.ejb.Local;

import com.the_bean_quartet.msc_project.entities.library;

@Local
public interface DAO {
	Collection<library> getLibraryData();

}
