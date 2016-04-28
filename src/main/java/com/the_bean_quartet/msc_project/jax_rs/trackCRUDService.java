package com.the_bean_quartet.msc_project.jax_rs;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.the_bean_quartet.msc_project.entities.Options;
import com.the_bean_quartet.msc_project.entities.playlistList;
import com.the_bean_quartet.msc_project.entities.track;
import com.the_bean_quartet.msc_project.entities.trackList;
import com.the_bean_quartet.msc_project.services.playlistService;
import com.the_bean_quartet.msc_project.services.trackService;

@Path("/track")
public class trackCRUDService {
	
	
	@Inject
	private trackService trackService;
	
	@Inject
	private playlistService playlistService;
	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
    public trackList getTrackData() {
		System.out.println("in track cruds");
        trackList data = new trackList();
       data.setTrackCollection(trackService.getTrackDataset());
        return data;
    }

	@GET
    @Path("/addtrack")
    public void addtrack() {
		track track=new track(1,"name","album");
		track track2=new track(2,"name2","album2");
		List<track> trackList = new ArrayList<track>();	
		trackList.add(track);
		trackList.add(track2);
		trackService.addTracks(trackList);
		
		
	}
	
	@POST
    @Path("/gettrackbyplaylist")
	@Consumes(MediaType.APPLICATION_JSON)
    public trackList getTrackByPlaylist(Options option) {
		System.out.println("in track cruds");
		
//		int userID=(Integer.parseInt(option.getOption1()));
		int playlistID=(Integer.parseInt(option.getOption1()));
		int p=212;
		String lib="542CEAB7C8BAE946";
		int u=1;
        trackList data = new trackList();
//        data.setTrackCollection(trackService.getTrackByPlaylist(u,lib, p));

                data.setTrackCollection(trackService.getTrackByPlaylist(u, playlistID));
        return data;
		
	}
	
 
	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
	@Path("/getplaylistid")
    public playlistList getTrackByPlaylist_playlistID() {
		System.out.println("in track cruds");
		
		playlistList data=new playlistList();
          data.setPlaylistCollection(playlistService.getTrackByPlaylist_playlistID());
        return data;
		
	}

	}
	
