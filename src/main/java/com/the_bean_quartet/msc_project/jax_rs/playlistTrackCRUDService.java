package com.the_bean_quartet.msc_project.jax_rs;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.the_bean_quartet.msc_project.entities.playlistList;
import com.the_bean_quartet.msc_project.entities.playlistTrackList;
import com.the_bean_quartet.msc_project.services.playlist_trackService;

@Path("/playlisttrack")
public class playlistTrackCRUDService {
	
	
	@Inject
	private playlist_trackService playlist_trackService ;
	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
    public playlistTrackList getPlaylistData() {
		System.out.println("in playlistTrackCRUDService cruds");
		playlistTrackList data = new playlistTrackList();
        data.setPlaylistTrackCollection(playlist_trackService.getPlaylist_track());
        return data;
    }
}
