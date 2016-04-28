package com.the_bean_quartet.msc_project.services;

import java.util.Collection;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.the_bean_quartet.msc_project.dao.trackDAO;
import com.the_bean_quartet.msc_project.entities.track;

@Stateless
@Local
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class trackServiceEJB implements trackService{
	
	@Inject 
	private trackDAO trackDAO;
	
//	@PersistenceContext
//	private EntityManager em;
	
	public Collection<track> getTrackDataset()
	{
		return trackDAO.getTrackData();

	}
	
	@Override
	public void addTracks(List<track>trackList){
		System.out.println("trackServiceEJB111111111111111111111");
		trackDAO.addTracks(trackList);

	}

	@Override
	public Collection<track> getTrackByPlaylist(int userID, int playlistID) {
		
		return trackDAO.getTrackByPlaylist(userID, playlistID);
	}

	@Override
	public Object getTrackByPlaylist_playlistID() {
		return trackDAO.getTrackByPlaylist_playlistID();
	}


}
