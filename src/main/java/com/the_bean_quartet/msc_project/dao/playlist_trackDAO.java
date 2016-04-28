package com.the_bean_quartet.msc_project.dao;

import java.util.Collection;

import javax.ejb.Local;

import com.the_bean_quartet.msc_project.entities.playlist_track;

@Local
public interface playlist_trackDAO {

	public void addPlaylist_track(Collection<playlist_track> playlist_track_list);
	public Collection<playlist_track> getPlaylist_track();

}
