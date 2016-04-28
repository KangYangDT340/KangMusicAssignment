package com.the_bean_quartet.msc_project.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement // this is required to enable JSON serialization
public class userList implements Serializable{
    private Collection<user> userCollection;
	
    public Collection<user> getUserCollection() {
        return userCollection;
    }

    public void setUserCollection(Collection<user> userCollection) {
        this.userCollection = userCollection;
    }




}
