package com.the_bean_quartet.msc_project.jax_rs;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.the_bean_quartet.msc_project.entities.libraryList;
import com.the_bean_quartet.msc_project.services.libraryService;

@Path("/library")
public class libraryCRUDService {
	
	
	@Inject
	private libraryService libraryService;
	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
    public libraryList getLibraryData() {
		System.out.println("in library cruds");
        libraryList data = new libraryList();
       data.setLibraryCollection(libraryService.getLibraryDataset());
        return data;
    }
}
