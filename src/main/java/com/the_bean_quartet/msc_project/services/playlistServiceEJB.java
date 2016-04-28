package com.the_bean_quartet.msc_project.services;

import java.util.Collection;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import com.the_bean_quartet.msc_project.dao.playlistDAO;
import com.the_bean_quartet.msc_project.entities.playlist;

@Stateless
@Local
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class playlistServiceEJB implements playlistService {
	
	@Inject 
	private playlistDAO playlistDAO;
	public Collection<playlist> getPlaylistDataset()
	{
		return playlistDAO.getPlaylistData();

	}
	@Override
	public void addPlaylists(Collection<playlist> playlistList) {
		playlistDAO.addPlaylists(playlistList);		
	}
	@Override
	public Collection<playlist> getTrackByPlaylist_playlistID() {
		// TODO Auto-generated method stub
		return playlistDAO.getTrackByPlaylist_playlistID();
	}

}
