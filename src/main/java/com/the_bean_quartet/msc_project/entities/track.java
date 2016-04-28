package com.the_bean_quartet.msc_project.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name="track")

@XmlRootElement
public class track implements Serializable {

	private static final long serialVersionUID = -7686433746648178330L;

	@Id
	@Column(name="trackID")private int trackID;
	@Column(name="Name")private String trackName;
	@Column(name="album")private String albumName;
	
	@OneToMany(mappedBy = "track")
	private Collection<playlist_track> playlists=new ArrayList<playlist_track>();
	
	public track(){}

	public track(int trackID, String trackName, String albumName){
		this.trackID=trackID;
		this.trackName=trackName;
		this.albumName=albumName;
	//	this.playlists=track;
	}
//	@JsonIgnore
//	@XmlTransient
//	public Collection<playlist> getPlaylists() {
//		return playlists;
//	}
//	public void setPlaylists(Collection<playlist> playlists) {
//		this.playlists = playlists;
//	}

	public int getTrackID() {
		return trackID;
	}
	public void setTrackID(int trackID) {
		this.trackID = trackID;
	}
	public String getTrackName() {
		return trackName;
	}
	public void setTrackName(String trackName) {
		this.trackName = trackName;
	}
	public String getAlbumName() {
		return albumName;
	}
	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}

}
		