package com.the_bean_quartet.msc_project.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement // this is required to enable JSON serialization
public class playlistTrackList implements Serializable{
    private Collection<playlist_track> playlist_trackCollection;
	
    public Collection<playlist_track> getPlaylistTrackCollection() {
        return playlist_trackCollection;
    }

    public void setPlaylistTrackCollection(Collection<playlist_track> playlist_trackCollection) {
        this.playlist_trackCollection = playlist_trackCollection;
    }




}
