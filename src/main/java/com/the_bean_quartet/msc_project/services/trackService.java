package com.the_bean_quartet.msc_project.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.ejb.Local;
import javax.sound.midi.Track;

import com.the_bean_quartet.msc_project.entities.track;


@Local
public interface trackService {

	public Collection<track> getTrackDataset();

	public void addTracks(List<track>trackList);

	public Collection<track> getTrackByPlaylist(int userID, int playlistID);

	public Object getTrackByPlaylist_playlistID();
}
