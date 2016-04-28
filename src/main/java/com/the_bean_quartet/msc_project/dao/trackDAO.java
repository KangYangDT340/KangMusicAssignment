package com.the_bean_quartet.msc_project.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.ejb.Local;

import com.the_bean_quartet.msc_project.entities.track;

@Local
public interface trackDAO {
	public Collection<track> getTrackData();
	public void addTracks(List<track> trackList);
	public Collection<track> getTrackByPlaylist(int userID, int playlistID);
	public Collection<track> getTrackByPlaylist_playlistID();

}
