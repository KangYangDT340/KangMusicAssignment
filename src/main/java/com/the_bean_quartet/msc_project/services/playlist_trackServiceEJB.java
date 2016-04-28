package com.the_bean_quartet.msc_project.services;

import java.util.Collection;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import com.the_bean_quartet.msc_project.dao.playlistDAO;
import com.the_bean_quartet.msc_project.dao.playlist_trackDAO;
import com.the_bean_quartet.msc_project.entities.playlist;
import com.the_bean_quartet.msc_project.entities.playlist_track;

@Stateless
@Local
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class playlist_trackServiceEJB implements playlist_trackService {
	
	@Inject 
	private playlist_trackDAO playlist_trackDAO;
	
	public void addPlaylist_track(Collection<playlist_track> playlist_track_list) {
		playlist_trackDAO.addPlaylist_track(playlist_track_list);
	}

	@Override
	public Collection<playlist_track> getPlaylist_track() {
		return playlist_trackDAO.getPlaylist_track();
	}
	



}
