package com.the_bean_quartet.msc_project.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement // this is required to enable JSON serialization
public class playlistList implements Serializable{
    private Collection<playlist> playlistCollection;
	
    public Collection<playlist> getPlaylistCollection() {
        return playlistCollection;
    }

    public void setPlaylistCollection(Collection<playlist> playlistCollection) {
        this.playlistCollection = playlistCollection;
    }




}
