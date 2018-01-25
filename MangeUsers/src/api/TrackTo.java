package api;

import java.util.ArrayList;
import java.util.Collection;

import poe.user.Track;
import poe.user.User;

public class TrackTo {
	
		     String titre;
		 
		     String artiste;
		     private Collection<UserTo>users;
		 
		     public Collection<UserTo> getUsers() {
				return users;
			}

			public void setUsers(Collection<UserTo> users) {
				this.users = users;
			}

			public String getTitre() {
		         return titre;
		     }
		 
		     public void setTitre(String titre) {
		         this.titre = titre;
		    }
		 
		     public String getArtiste() {
		         return artiste;
		     }
		 
		     public void setArtiste(String artiste) {
		         this.artiste = artiste;
		     }
		 
		     public static TrackTo buildFrom(Track track) {
		       
		         TrackTo trackTo = new TrackTo();
		         trackTo.setTitre(track.getTitre());
		         trackTo.setArtiste(track.getArtiste());
		        
		         Collection<UserTo> users = new ArrayList<>();
		         for (User user : track.getUsers()) {
		             UserTo userTo = new UserTo();
		             userTo.setEmail(user.getEmail());
		             userTo.setPassword(user.getMotPasse());
		             users.add(userTo);
		         }
		         trackTo.setUsers(users);
		         return trackTo;
		 
		 }

}
