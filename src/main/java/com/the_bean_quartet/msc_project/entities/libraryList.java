package com.the_bean_quartet.msc_project.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement // this is required to enable JSON serialization
public class libraryList implements Serializable{
    private Collection<library> libraryCollection;
	
    public Collection<library> getLibraryCollection() {
        return libraryCollection;
    }

    public void setLibraryCollection(Collection<library> libraryCollection) {
        this.libraryCollection = libraryCollection;
    }




}
