package api;

import java.util.ArrayList;
import java.util.Collection;

import poe.user.Track;
import poe.user.User;

public class UserTo {
	
	 String email;
	 
	     String password;
	 
	     Collection<TrackTo> tracks;
	 
	     public String getEmail() {
	         return email;
	     }
	 
	     public void setEmail(String email) {
	         this.email = email;
	     }
	 
	     public String getPassword() {
	        return password;
	     }
	 
	     public void setPassword(String password) {
	         this.password = password;
	     }
	 
	     public Collection<TrackTo> getTracks() {
	         return tracks;
	     }
	 
	     public void setTracks(Collection<TrackTo> tracks) {
	         this.tracks = tracks;
	     }
	 
	     public static UserTo buildFrom(User user) {
	         UserTo userTo = new UserTo();
	         userTo.setEmail(user.getEmail());
	         userTo.setPassword(user.getMotPasse());
	         Collection<TrackTo> tracks = new ArrayList<>();
	         for (Track track : user.getTracks()) {
	             TrackTo trackTo = new TrackTo();
	             trackTo.setTitre(track.getTitre());
	             trackTo.setArtiste(track.getArtiste());
	             tracks.add(trackTo);
	         }
	         userTo.setTracks(tracks);
	         return userTo;
	     }

}
