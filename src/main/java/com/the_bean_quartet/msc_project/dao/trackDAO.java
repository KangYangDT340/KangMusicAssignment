package com.the_bean_quartet.msc_project.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.ejb.Local;

import com.the_bean_quartet.msc_project.entities.playlist_track;
import com.the_bean_quartet.msc_project.entities.track;

@Local
public interface trackDAO {
	public Collection<track> getTrackData();
	public void addTracks(List<track> trackList);
	public Collection<playlist_track> getTrackByPlaylist(int userID, int playlistID);
	public Collection<track> getTrackByPlaylist_playlistID();
	public String reNameTrack(int id, String name);
	public Collection<track> getTrackByPlaylist_trackID();
	public String deleteTrack(int id);
	public String moveTrack(int p_id, int track_id, int to_p_id);

}
