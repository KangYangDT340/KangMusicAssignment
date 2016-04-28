package com.the_bean_quartet.msc_project.jax_rs;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.the_bean_quartet.msc_project.entities.playlistList;
import com.the_bean_quartet.msc_project.services.playlistService;

@Path("/playlist")
public class playlistCRUDService {
	
	
	@Inject
	private playlistService playlistService ;
	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
	@Path("/getplaylist")
    public playlistList getPlaylistData() {
		System.out.println("in getPlaylistData cruds");
        playlistList data = new playlistList();
        data.setPlaylistCollection(playlistService .getPlaylistDataset());
        return data;
    }
}
