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

import com.the_bean_quartet.msc_project.dao.playlist_trackDAO;
import com.the_bean_quartet.msc_project.entities.playlist_track;
import com.the_bean_quartet.msc_project.entities.track;

@Stateless
@Local
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class playlist_trackJPA implements playlist_trackDAO{
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void addPlaylist_track(Collection<playlist_track> playlist_track_list) {
		System.out.println("In JPA playlist_trackJPA");
		for(playlist_track playlist_track : playlist_track_list) {
			em.persist(playlist_track);
		}	
	}
	
	@Override
	public Collection<playlist_track> getPlaylist_track(){
		System.out.println("In JPA playlist_trackJPA");
		Query query = em.createQuery("from playlistTrack");
		List<playlist_track> bData = query.getResultList(); 
		return bData;
	}



}
