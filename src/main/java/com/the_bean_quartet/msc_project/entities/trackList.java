package com.the_bean_quartet.msc_project.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement // this is required to enable JSON serialization
public class trackList implements Serializable{
    private Collection<track> trackCollection;
	
    public Collection<track> getTrackCollection() {
        return trackCollection;
    }

    public void setTrackCollection(Collection<track> trackCollection) {
        this.trackCollection = trackCollection;
    }




}
