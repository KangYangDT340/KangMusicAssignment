package com.the_bean_quartet.msc_project.dao.jpa;

import java.util.Collection;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.the_bean_quartet.msc_project.dao.trackDAO;
import com.the_bean_quartet.msc_project.entities.track;

@Stateless
@Local
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class trackJPA implements trackDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	public Collection<track> getTrackData() {
		Query query = em.createQuery("from track");
		List<track> bData = query.getResultList(); 
		return bData;
	}
	

//	@Override
	public void addTracks(List<track> trackList) {
		System.out.println("In JPA Track DAO");
		for(track track : trackList) {
			em.merge(track);
		}		
	}


	@Override
	public Collection<track> getTrackByPlaylist(int userID, int playlistID) {
		Query query = em.createQuery("select p.track.trackID, p.track.trackName, p.track.albumName from playlist_track p where p.playlistID = :playlistID"
				+ " and p.playlist.libraryPID.user.userID=:userID");
//		.trackID, p.track.trackName, p.track.trackAlbum 
		query.setParameter("playlistID", playlistID);
		query.setParameter("userID", userID);
		//Query query = em.createQuery("from Playlist_Track_Link");
		List<track> data = query.getResultList();
//		System.out.println("number of rows acquired: "+data.size());
		return data;
	}


	@Override
	public Collection<track> getTrackByPlaylist_playlistID() {
		Query query = em.createQuery("select p.playlistID from playlist_track p");
		List<track> data = query.getResultList();

		return data;
	}
	@Override
	public Collection<track> getTrackByPlaylist_trackID() {
		Query query = em.createQuery("select p.trackID from playlist_track p");
		List<track> data = query.getResultList();

		return data;
	}

	@Override
	public String reNameTrack(int id, String name) {
		Query query = em.createQuery("update playlist_track set track.trackName = :name where trackId = :id");
		query.setParameter("name", name);
		query.setParameter("id", id);
		track track = em.find(track.class, id);
		track.setTrackName(name); 
		em.merge(track); 
		return "Name Changed";
	}
		


		
	
}
