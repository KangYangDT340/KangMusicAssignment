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
import com.the_bean_quartet.msc_project.entities.playlistTrackList;
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
	@Produces(MediaType.APPLICATION_JSON)
    public playlistTrackList getTrackByPlaylist(Options option) {
		System.out.println("in track cruds");
		
//		int userID=(Integer.parseInt(option.getOption1()));
		int playlistID=(Integer.parseInt(option.getOption1()));
		int p=212;
		String lib="542CEAB7C8BAE946";
		int u=1;
		playlistTrackList data = new playlistTrackList();
//        data.setTrackCollection(trackService.getTrackByPlaylist(u,lib, p));

                data.setPlaylistTrackCollection(trackService.getTrackByPlaylist(u, playlistID));
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
	@GET
    @Produces(MediaType.APPLICATION_JSON)
	@Path("/gettrackid")
    public trackList getTrackByPlaylist_trackID() {
		System.out.println("in track cruds");
		
		trackList data=new trackList();
          data.setTrackCollection(trackService.getTrackByPlaylist_trackID());
        return data;
		
	}
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/changename")
	public String setPlaylistName(Options opt){
		String name = opt.getOption2();
		int id = Integer.parseInt(opt.getOption1());
		return trackService.reNameTrack(id, name);
	}
		
	
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/delete")
	public String deleteTrack(Options opt){
		System.out.println(opt.getOption1());
		int id = Integer.parseInt(opt.getOption1());
		return trackService.deleteTrack(id);
	}
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/move")
	public String moveTrack(Options opt){
		int p_id = Integer.parseInt(opt.getOption1());
		int to_p_id = Integer.parseInt(opt.getOption3());
		int track_id = Integer.parseInt(opt.getOption2());
		return trackService.moveTrack(p_id,track_id,to_p_id);
	}
	


}
	
