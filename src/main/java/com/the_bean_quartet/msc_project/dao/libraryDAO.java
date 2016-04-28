package com.the_bean_quartet.msc_project.dao;

import java.util.Collection;

import javax.ejb.Local;

import com.the_bean_quartet.msc_project.entities.library;
import com.the_bean_quartet.msc_project.entities.track;

@Local
public interface libraryDAO {
	Collection<library> getLibraryData();
	void addLibrary(library library);


}
