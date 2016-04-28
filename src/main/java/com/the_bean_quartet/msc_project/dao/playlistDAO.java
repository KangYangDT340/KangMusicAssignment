package com.the_bean_quartet.msc_project.dao;

import java.util.Collection;

import javax.ejb.Local;

import com.the_bean_quartet.msc_project.entities.playlist;

@Local
public interface playlistDAO {
	Collection<playlist> getPlaylistData();

	void addPlaylists(Collection<playlist> playlistList);

	Collection<playlist> getTrackByPlaylist_playlistID();

}
