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

import com.the_bean_quartet.msc_project.dao.playlistDAO;
import com.the_bean_quartet.msc_project.entities.playlist;
import com.the_bean_quartet.msc_project.entities.track;

@Stateless
@Local
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class playlistJPA implements playlistDAO {
	@PersistenceContext
	private EntityManager em;
	
	public Collection<playlist> getPlaylistData() {
		Query query = em.createQuery("from playlist");
		List<playlist> bData = query.getResultList(); 
		return bData;
	}

	public void addPlaylists(Collection<playlist> playlistList) {
		System.out.println("In JPA playlist DAO");
		for(playlist playlist : playlistList) {
			em.persist(playlist);
		}		
	}

	@Override
	public Collection<playlist> getTrackByPlaylist_playlistID() {
		Query query = em.createQuery("select p.playlistID from playlist p");
		List<playlist> bData = query.getResultList(); 
		return bData;
	}
}
