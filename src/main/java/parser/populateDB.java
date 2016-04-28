package parser;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.the_bean_quartet.msc_project.entities.library;
import com.the_bean_quartet.msc_project.entities.playlist;
import com.the_bean_quartet.msc_project.entities.playlist_track;
import com.the_bean_quartet.msc_project.entities.track;
import com.the_bean_quartet.msc_project.entities.user;
import com.the_bean_quartet.msc_project.services.libraryService;
import com.the_bean_quartet.msc_project.services.playlistService;
import com.the_bean_quartet.msc_project.services.playlist_trackService;
import com.the_bean_quartet.msc_project.services.trackService;

import generated.Array;
import generated.Dict;
import generated.Key;
import generated.ObjectFactory;
import generated.Plist;

//@Local
//@Stateless
public class populateDB {

	@Inject
	private libraryService libraryService;
	@Inject
	private playlistService playlistService;
	@Inject
	private trackService trackService;
	@Inject
	private playlist_trackService playlist_trackService;

	 @PersistenceContext private EntityManager em;

//	private Collection<user> userList = new ArrayList<user>();
	private List<track> trackList = new ArrayList<track>();

	private Collection<playlist> playlistList = new ArrayList<playlist>();
	private Collection<playlist_track> playlist_track_list = new ArrayList<playlist_track>();

	private library library = new library();
//	private library library2 = new library();

	private track track = new track();
	// private Collection<library>library = new ArrayList<library>();
	// private Collection<user> user=new ArrayList<user>();
	private user user1=new user("name1","passowrd1");
	private user user2=new user("name2","passowrd2");

	String libraryPid = null;
	Dict trackDict = null;
	Array playlistArray = null;
	Array trackArray = null;
	Dict tracListkDict = null;
	Dict arrayDict = null;
	Dict arrayDictKey = null;
	List<Object> trackArrayLists = null;
	List<Object> childofRootDict = null;

	private static String path3 = "iTunes Music Library3.xml";
	static String xxx = "C:\\Users\\Kang\\Desktop\\iTunes Music Library3.xml";
	static String zzz = "C://Users//Kang//Desktop//iTunes Music Library3.xml";

	public populateDB() {
	}

	 public void populate(File path) throws JAXBException {
//	public void populate() throws JAXBException {

		// System.out.println("path is 1111111111112123
		// "+path.getAbsolutePath());
		try {
			 plistGenerate(path);
//			plistGenerate();

		} catch (UnsupportedEncodingException | FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	 public void plistGenerate(File path) throws JAXBException,UnsupportedEncodingException, FileNotFoundException{
//	public void plistGenerate() throws JAXBException, UnsupportedEncodingException, FileNotFoundException {
		// System.out.println("hellllllllllllllllo");
		JAXBContext jaxbContext = JAXBContext.newInstance(ObjectFactory.class);
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

		// Unmarshaller unmarshaller = jc.createUnmarshaller();
		InputStream inputStream = new FileInputStream(path);
		Reader reader = new InputStreamReader(inputStream, "UTF-8");
		Plist plist = (Plist) unmarshaller.unmarshal(reader);

		// Plist plist = (Plist) unmarshaller.unmarshal(new File("iTunes Music
		// Library3.xml"));

		// String path=file.getAbsolutePath();
		// Plist plist = (Plist) unmarshaller.unmarshal(new File(xxx));
//		System.out.println(plist);
		List<Object> rootObject = plist.getArrayOrDataOrDateOrDictOrRealOrIntegerOrStringOrTrueOrFalse();
		//
		// //first dict tag
		Dict dict = (Dict) rootObject.get(0);
//		System.out.println(dict);
//		System.out.println(
//				((Key) dict.getKeyOrArrayOrDataOrDateOrDictOrRealOrIntegerOrStringOrTrueOrFalse().get(0)).getvalue());
		childofRootDict = dict.getKeyOrArrayOrDataOrDateOrDictOrRealOrIntegerOrStringOrTrueOrFalse();

		addLibrary();
		addTrack();
		addPlaylist();
//		user user = new user("name", "passowrd");
		// System.out.println("11111111 " +user.getUserID());
		// System.out.println("11111111 " +user1.getUserID());

		// playlistList.add(new playlist(1,"name",));
		// trackList.add(new track(1,"Name","Album"));
		// System.out.println("hellllllllllllllllo");
//		library.setUser(user1);
//		userService.addUser(user2);

//		library2.setUser(user2);

//		print();
		// System.out.println("hellllllllllllllllo"
		// +
		// "8888888888888888888888888888888888888"+trackList.get(0).getTrackName());
		// trackService.addTracks((Collection)trackList);
		 System.out.println("hellllllllllllllllo");

		 trackService.addTracks(trackList);
		// userService.addUser(user);
		 libraryService.addLibrary(library);
		 playlistService.addPlaylists(playlistList);
		 playlist_trackService.addPlaylist_track(playlist_track_list);

		 System.out.println("hellllllllllllllllo");

	}

	public void print() {

		for(playlist_track t: playlist_track_list){
			System.out.println("playlist_trackID "+t.getPlaylistTrackID()+" playlist_track_playlistID "
		+t.getPlaylistID()+" playlist_track_trackID"+t.getTrackID());
			
		}
//		System.out.println("libraryPersistentID: "+library.getLibraryPID());
//		System.out.println("UserID: "+library.getUser().getUserID()+" userName "+library.getUser().getUserName()+"  "
//				+" userpassword: "+library.getUser().getUserPassword());
//		System.out.println("UserID: "+library2.getUser().getUserID()+" userName "+library2.getUser().getUserName()+"  "
//				+" userpassword: "+library2.getUser().getUserPassword());
//		System.out.println("Print track11111111111111111");
//		for (track t : trackList) {
//			System.out.println("TrackID: "+t.getTrackID() + "TrackAlbum: "+t.getAlbumName() + "TrackName: "+t.getTrackName());
//		}


//		 System.out.println("Print playlist11111111111111111");
//		 for(playlist t: playlistList){
//		 System.out.println("playlist "+  " playlistID: "+t.getPlaylistID()+" playlistName: "
//		 +t.getPlaylistName()+" playlistlibrary "+t.getLibraryPID().getLibraryPID());
//		 for(track s: t.getTracks()){
//		 System.out.println("playlisttrack ID "+s.getTrackID()+ " track name"+s.getAlbumName());
//		 }
//		 }
		// trackService.addTracks(trackList);

	}

	public void addLibrary() {
		//
		for (int i = 0; i < childofRootDict.size(); i++) {
			// dict - key
			if (childofRootDict.get(i).getClass().getName().contains("Key")) {

				if (((Key) childofRootDict.get(i)).getvalue().equals("Library Persistent ID")) {
					libraryPid = ((generated.String) childofRootDict.get(i + 1)).getvalue();
					System.out.println("Library Persistent ID: " + libraryPid);
					library.setLibraryPID(libraryPid);
				}
			}
			// dict - dict
			// Second Dict tag
			if (childofRootDict.get(i).getClass().getName().contains("Dict")) {
				// System.out.println(childofRootDict.get(i));
				trackDict = (Dict) childofRootDict.get(i);
			}
			// dict -array
			// playlist arary
			if (childofRootDict.get(i).getClass().getName().contains("Array")) {
				playlistArray = (Array) childofRootDict.get(i);
			}
		}

		 library.setUser(em.find(user.class, 1));
		// library.add(new library(libraryPid,user));

	}

	public void addTrack() {
		// list of second dict
		List<Object> trackofRootDict = trackDict.getKeyOrArrayOrDataOrDateOrDictOrRealOrIntegerOrStringOrTrueOrFalse();

		for (int i = 0; i < trackofRootDict.size(); i++) {

			// dict - dict -dict
			// third Dict tag
			if (trackofRootDict.get(i).getClass().getName().contains("Dict")) {
				// System.out.println((Dict)trackofRootDict.get(i));
				tracListkDict = (Dict) trackofRootDict.get(i);

				trackList.add(getTrackDetail(tracListkDict));
			}

		}

	}

	public track getTrackDetail(Dict tracListkDict) {
		String Album = "";
		int trackID = 0;
		String Name = "";
		track trackx = new track();
		List<Object> trackListofRootDict = tracListkDict
				.getKeyOrArrayOrDataOrDateOrDictOrRealOrIntegerOrStringOrTrueOrFalse();

//		System.out.println("size of something...... " + trackListofRootDict.size());
		for (int j = 0; j < trackListofRootDict.size(); j++) {
//			System.out.println(trackListofRootDict.get(j));

			// dict - dict -dict-key
			if (trackListofRootDict.get(j).getClass().getName().contains("Key")) 
			{
				if (((Key) trackListofRootDict.get(j)).getvalue().equals("Track ID"))
				{
					trackID = Integer.parseInt(((generated.Integer) trackListofRootDict.get(j + 1)).getvalue());
					// System.out.println(trackListofRootDict.get(j+1).getClass().getName());
//					 System.out.println("trackID: "+trackID);
					trackx.setTrackID(trackID);
				}
				else if (((Key) trackListofRootDict.get(j)).getvalue().equals("Name")) 
				{
					Name = ((generated.String) trackListofRootDict.get(j + 1)).getvalue();
//					 System.out.println("Name: "+Name);
					trackx.setTrackName(Name);

				}
				else if (((Key) trackListofRootDict.get(j)).getvalue().equals("Album"))
				{
					Album = ((generated.String) trackListofRootDict.get(j + 1)).getvalue();
//					 System.out.println("Album: "+Album);
					// System.out.println("trackID: "+trackID);
					// System.out.println("Name: "+Name);
					// System.out.println("Album: "+Album);
						trackx.setAlbumName(Album);

				}
				if(trackID!=0 && Name!=""&&Album==""){
					 Album="empty";
//					 System.out.println("Album: "+Album);
						trackx.setAlbumName(Album);
				 }

				// trackList.add(trackx);
			} // trackList
		}
//		System.out.println(trackx.getTrackID() + trackx.getTrackName() + trackx.getAlbumName());
		return trackx;
	}

	// System.out.println("Finished tracks");

	public void addPlaylist() {

		List<Object> playlistArrayList = playlistArray.getArrayOrDataOrDateOrDictOrRealOrIntegerOrStringOrTrueOrFalse();

		for (int i = 0; i < playlistArrayList.size(); i++) {

			// go to dict
			if (playlistArrayList.get(i).getClass().getName().contains("Dict")) {
				arrayDict = (Dict) playlistArrayList.get(i);
				playlistList.add(getPlaylistDetail(arrayDict));
			}
		}
	}

	public playlist getPlaylistDetail(Dict arrayDict) {
		String Name = null;
		int playlistID = 0;
		playlist playlist = new playlist();
		List<Object> arrayDictLists = arrayDict.getKeyOrArrayOrDataOrDateOrDictOrRealOrIntegerOrStringOrTrueOrFalse();
		playlist.setLibraryPID(library);

		for (int j = 0; j < arrayDictLists.size(); j++) {

			if (arrayDictLists.get(j).getClass().getName().contains("Key")) {

				if (((Key) arrayDictLists.get(j)).getvalue().equals("Name"))
				{
					Name = ((generated.String) arrayDictLists.get(j + 1)).getvalue();
					// System.out.println("Name: "+Name);
					playlist.setPlaylistName(Name);
				}
				if (((Key) arrayDictLists.get(j)).getvalue().equals("Playlist ID")) 
				{
					playlistID = Integer.parseInt(((generated.Integer) arrayDictLists.get(j + 1)).getvalue());
					// System.out.println("Name: "+Name);
					// System.out.println("Playlist ID: "+playlistID);
					playlist.setPlaylistID(playlistID);
					// System.out.println("trackID: "+singleTrackList.size());
				}


//				playlist.setTracks(setPlaylistTracks(arrayDictLists));
			}

		}
		setPlaylistTracks(arrayDictLists,playlist);

		return playlist;

	}

	public void setPlaylistTracks(List<Object> arrayDictLists,playlist playlist) 
	{

		playlist_track playlist_track;
	
		int trackID = 0;
		Collection<track> singleTrackList = new ArrayList<track>();
		// System.out.println("Name: "+Name);
		// System.out.println("Playlist ID: "+playlistID);
		// dict - array -dict- Array
		for (int k = 0; k < arrayDictLists.size(); k++) {
			if (arrayDictLists.get(k).getClass().getName().contains("Array")) {
				trackArray = (Array) arrayDictLists.get(k);
				trackArrayLists = trackArray.getArrayOrDataOrDateOrDictOrRealOrIntegerOrStringOrTrueOrFalse();
	
				for (int a = 0; a < trackArrayLists.size(); a++) {
	
					// dict - array -dict- Array -dict
					if (trackArrayLists.get(a).getClass().getName().contains("Dict")) {
	
						arrayDictKey = (Dict) trackArrayLists.get(a);
	
						List<Object> arrayDictKeyLists = arrayDictKey
								.getKeyOrArrayOrDataOrDateOrDictOrRealOrIntegerOrStringOrTrueOrFalse();
						for (int b = 0; b < arrayDictKeyLists.size(); b++)
						{
							// dict - array -dict- Array -dict-key
							if (arrayDictKeyLists.get(b).getClass().getName().contains("Key"))
							{
								if (((Key) arrayDictKeyLists.get(b)).getvalue().equals("Track ID")) 
								{
	
									trackID = Integer
											.parseInt(((generated.Integer) arrayDictKeyLists.get(b + 1)).getvalue());
									// System.out.println("Track ID: "+trackID);
	
									for (track t : trackList) 
									{
										// System.out.println("22222");
	
										if (t.getTrackID() == trackID) 
										{
											// System.out.println(trackID);
	//										singleTrackList.add(t);
											if(playlist.getPlaylistID()!=0)
											{
												String playlistTrackID = trackID+""+playlist.getPlaylistID()+"";

														playlist_track=new playlist_track(playlist,t);
//														System.out.println("playlist: "+playlist.getPlaylistID()+"Track: "+t.getTrackID());
														
														boolean bool = false;
														
														for(playlist_track playlistTrack:playlist_track_list)
														{

															String id_ = playlistTrack.getTrackID()+""+playlistTrack.getPlaylistID();
															if(playlistTrackID.equals(id_)){
//																System.out.println("playlist id: "+playlistTrack.getPlaylistID());
//																System.out.println("track id: "+playlistTrack.getTrackID());
																bool = true;
															}
														}
														if(!bool)
															playlist_track_list.add(playlist_track);
												
											}
											
	
										}
									}
	
								}
	
							}
						}
					}
				}
	
			}
		}
	}
//	public Collection<track> setPlaylistTracks(List<Object> arrayDictLists,playlist playlist) {
//		
////		playlist_track;
//		playlist_track playlist_track;
//
//		int trackID = 0;
//		Collection<track> singleTrackList = new ArrayList<track>();
//		// System.out.println("Name: "+Name);
//		// System.out.println("Playlist ID: "+playlistID);
//		// dict - array -dict- Array
//		for (int j = 0; j < arrayDictLists.size(); j++) {
//			if (arrayDictLists.get(j).getClass().getName().contains("Array")) {
//				trackArray = (Array) arrayDictLists.get(j);
//				trackArrayLists = trackArray.getArrayOrDataOrDateOrDictOrRealOrIntegerOrStringOrTrueOrFalse();
//
//				for (int a = 0; a < trackArrayLists.size(); a++) {
//
//					// dict - array -dict- Array -dict
//					if (trackArrayLists.get(a).getClass().getName().contains("Dict")) {
//
//						arrayDictKey = (Dict) trackArrayLists.get(a);
//
//						List<Object> arrayDictKeyLists = arrayDictKey
//								.getKeyOrArrayOrDataOrDateOrDictOrRealOrIntegerOrStringOrTrueOrFalse();
//						for (int b = 0; b < arrayDictKeyLists.size(); b++) {
//							// dict - array -dict- Array -dict-key
//							if (arrayDictKeyLists.get(b).getClass().getName().contains("Key")) {
//								if (((Key) arrayDictKeyLists.get(b)).getvalue().equals("Track ID")) {
//
//									trackID = Integer
//											.parseInt(((generated.Integer) arrayDictKeyLists.get(b + 1)).getvalue());
//									// System.out.println("Track ID: "+trackID);
//
//									for (track t : trackList) {
//										// System.out.println("22222");
//
//										if (t.getTrackID() == trackID) {
//											// System.out.println(trackID);
////											singleTrackList.add(t);
//											playlist_track=new playlist_track(playlist,t);
//										}
//									}
//
//								}
//
//							}
//						}
//					}
//				}
//
//			}
//		}
//		return singleTrackList;
//	}

	// Remember if there is a dict or an array you can return the children as a
	// list
	// public static void main(String arg[]) throws JAXBException{
	// populateDB db=new populateDB();
	// db.populate();
	// }

}
