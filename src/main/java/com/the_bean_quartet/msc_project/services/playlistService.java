package com.the_bean_quartet.msc_project.services;

import java.util.Collection;

import javax.ejb.Local;

import com.the_bean_quartet.msc_project.entities.playlist;


@Local
public interface playlistService {
	public Collection<playlist> getPlaylistDataset();

	public void addPlaylists(Collection<playlist> playlistList);

	public Collection<playlist> getTrackByPlaylist_playlistID();


	
}
