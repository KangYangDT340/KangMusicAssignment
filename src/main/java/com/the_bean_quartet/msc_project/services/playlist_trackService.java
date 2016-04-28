package com.the_bean_quartet.msc_project.services;

import java.util.Collection;

import javax.ejb.Local;

import com.the_bean_quartet.msc_project.entities.playlist;
import com.the_bean_quartet.msc_project.entities.playlist_track;

@Local
public interface playlist_trackService {
	public Collection<playlist_track> getPlaylist_track();
	public void addPlaylist_track(Collection<playlist_track> playlist_track_list);
	
	
}
