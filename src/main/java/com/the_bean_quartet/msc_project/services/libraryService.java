package com.the_bean_quartet.msc_project.services;

import java.util.Collection;

import javax.ejb.Local;

import com.the_bean_quartet.msc_project.entities.library;
import com.the_bean_quartet.msc_project.entities.track;
import com.the_bean_quartet.msc_project.entities.user;


@Local
public interface libraryService {
	Collection<library> getLibraryDataset();

	void addLibrary(library library);

	Collection<library> getUserDetailData();

}
