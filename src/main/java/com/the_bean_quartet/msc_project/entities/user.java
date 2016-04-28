package com.the_bean_quartet.msc_project.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="user")

@XmlRootElement
public class user implements Serializable {

	private static final long serialVersionUID = -7686433746648178330L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="userID")private int userID;
	@Column(name="userName")private String userName;
	@Column(name="userPassword")private String userPassword;
	
	@OneToMany(mappedBy="user",fetch = FetchType.EAGER)
	private List<library> library;
	

	
	//@XmlTransient
//	@JsonIgnore
//	public List<library> getLibrary() {
//		return library;
//	}
/*	public void setLibrary(List<library> library) {
		this.library = library;
	}*/
	public user(){}
//	public user(int userID,String userName, String userPassword){
//		this.userName=userName;
//		this.userPassword=userPassword;
//		this.userID=userID;
//	}
	public user(String userName, String userPassword){
		this.userName=userName;
		this.userPassword=userPassword;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}

}