package com.the_bean_quartet.msc_project.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="playlist")

@XmlRootElement
public class playlist implements Serializable {

	private static final long serialVersionUID = -7686433746648178330L;

	@Id
	@Column(name="playlistID")private int playlistID;
	
	@Column(name="playlistName")private String playlistName;
	
	@ManyToOne
	@JoinColumns({ @JoinColumn(name = "libraryPID", referencedColumnName = "libraryPID")})
	private library libraryPID;
	

//	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//	@JoinTable(name = "playlistTrack", joinColumns = { 
//			@JoinColumn(name = "playlistID", nullable = false, updatable = false) 
//			}, 
//			inverseJoinColumns = { @JoinColumn(name = "trackID", nullable = false, updatable = false) })
//	private Collection<track> tracks= new ArrayList<track>();
	
	public playlist(){}

	public playlist(int playlistID, String playlistName){
		this.playlistID=playlistID;
		this.playlistName=playlistName;

	}
//	@JsonIgnore
//	public Collection<track> getTracks() {
//		return tracks;
//	}
//	public void setTracks(Collection<track> tracks) {
//		this.tracks = tracks;
//	}
//	@JsonIgnore
	public library getLibraryPID() {
		return libraryPID;
	}
	public void setLibraryPID(library libraryPID) {
		this.libraryPID = libraryPID;
	}

	public int getPlaylistID() {
		return playlistID;
	}
	public void setPlaylistID(int playlistID) {
		this.playlistID = playlistID;
	}
	public String getPlaylistName() {
		return playlistName;
	}
	public void setPlaylistName(String playlistName) {
		this.playlistName = playlistName;
	}

	
}