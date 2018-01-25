package poe.user;

import java.io.Serializable;
import java.util.Collection;


import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class TrackController implements Serializable{
	public TrackDao getTrackDao() {
		return trackDao;
	}

	public void setTrackDao(TrackDao trackDao) {
		this.trackDao = trackDao;
	}

	public Track getTrack() {
		return track;
	}

	public void setTrack(Track track) {
		this.track = track;
	}

	private static final long serialVersionUID = 1L;
	
	@EJB
	TrackDao trackDao;
	
	Track track ;
	
	public TrackController() {
		
		this.track = new Track();
		
	}
	
	public long add(Track track) {
		trackDao.addTrackDao(track);
		return track.getId();
		
	}
	
	public Collection<Track> TracksList(){
		return trackDao.getTracksListDao();
	}
	
	public Track getTrackById(long id) {
		return trackDao.getTrackById(id);
	}
	
	public void delete(long trackId) {
		
		trackDao.delete(trackId);
	}
	
	public void edit(long id) {
		Track track = trackDao.getTrackById(id);
		this.track = track;
	}


	public void update(Track track) {
		this.track = track;
		trackDao.edit(this.track);

		

	}
	
	
	

}
