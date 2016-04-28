package com.the_bean_quartet.msc_project.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "playlistTrack")
public class playlist_track implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "playlistTrackID")
	private String playlistTrackID;


	@Column(name = "trackID")
	private int trackID;
	
	@Column(name = "playlistID")
	private int playlistID;
	
	@ManyToOne
	@JoinColumn(name = "playlist", referencedColumnName = "playlistID")
	private playlist playlist;

	@ManyToOne
	@JoinColumn(name = "track", referencedColumnName = "trackID")
	private track track;



	public playlist_track() {}

	public playlist_track(playlist playlist, track track) {
		this.playlist = playlist;
		this.track = track;
		this.trackID = track.getTrackID();
		this.playlistID = playlist.getPlaylistID();
		this.playlistTrackID = track.getTrackID()+""+playlist.getPlaylistID()+"";
	}

	public String getPlaylistTrackID() {
		return playlistTrackID;
	}



	public void setPlaylistTrackID(String playlistTrackID) {
		this.playlistTrackID = playlistTrackID;
	}



	public int getTrackID() {
		return trackID;
	}



	public void setTrackID(int trackID) {
		this.trackID = trackID;
	}



	public int getPlaylistID() {
		return playlistID;
	}



	public void setPlaylistID(int playlistID) {
		this.playlistID = playlistID;
	}



	public playlist getPlaylist() {
		return playlist;
	}



	public void setPlaylist(playlist playlist) {
		this.playlist = playlist;
	}



	public track getTrack() {
		return track;
	}



	public void setTrack(track track) {
		this.track = track;
	}









	
	
}