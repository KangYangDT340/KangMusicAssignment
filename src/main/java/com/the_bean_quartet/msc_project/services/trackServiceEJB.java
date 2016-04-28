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
import com.the_bean_quartet.msc_project.entities.playlist_track;
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
	public Collection<playlist_track> getTrackByPlaylist(int userID, int playlistID) {
		
		return trackDAO.getTrackByPlaylist(userID, playlistID);
	}

	@Override
	public Object getTrackByPlaylist_playlistID() {
		return trackDAO.getTrackByPlaylist_playlistID();
	}

	@Override
	public String reNameTrack(int id, String name) {
		// TODO Auto-generated method stub
		return trackDAO.reNameTrack(id,name);
	}

	@Override
	public Collection<track> getTrackByPlaylist_trackID() {
		// TODO Auto-generated method stub
		return trackDAO.getTrackByPlaylist_trackID();
	}

	@Override
	public String deleteTrack(int id) {
		// TODO Auto-generated method stub
		return trackDAO.deleteTrack(id);
	}

	@Override
	public String moveTrack(int p_id, int track_id, int to_p_id) {
		// TODO Auto-generated method stub
		return trackDAO.moveTrack(p_id,track_id,to_p_id);
	}


}
