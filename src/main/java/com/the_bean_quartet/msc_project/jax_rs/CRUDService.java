package com.the_bean_quartet.msc_project.jax_rs;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.the_bean_quartet.msc_project.entities.libraryList;
import com.the_bean_quartet.msc_project.services.IpodService;

@Path("/library")
public class CRUDService {
	@Inject
	private IpodService service;
	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
    public libraryList getBaseData() {
		libraryList data = new libraryList();
        data.setLibraryCollection(service.getLibraryDataset());
        return data;
    }
}
