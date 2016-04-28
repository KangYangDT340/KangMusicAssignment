package com.the_bean_quartet.msc_project.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name="library")
@XmlRootElement
public class library implements Serializable {

	private static final long serialVersionUID = -7686433746648178330L;

	@Id
	@Column(name="libraryPID")private String libraryPID;
	
	@ManyToOne
	@JoinColumns({ @JoinColumn(name = "userID", referencedColumnName = "userID")})
	private user user;
	
	
	//fetch = FetchType.EAGER
	@OneToMany(mappedBy="libraryPID")
	private Collection<playlist> playlists=new ArrayList<playlist>();

//	public Collection<playlist> getPlaylists() {
//		return playlists;
//	}
/*	public void setPlaylists(Collection<playlist> playlists) {
		this.playlists = playlists;
	}*/
	public library(){}
	public library(String libraryPID, user userID ){
		this.libraryPID=libraryPID;
		this.user=userID;
	}
	public user getUser() {
		return user;
	}
	public void setUser(user userID) {
		this.user = userID;
	}
	public String getLibraryPID() {
		return libraryPID;
	}
	public void setLibraryPID(String libraryPID) {
		this.libraryPID = libraryPID;
	}

	
}