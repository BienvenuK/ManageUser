package poe.user;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

import api.UserTo;



@ManagedBean
@RequestScoped

@Entity
public class Track implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@JoinColumn(name="strack")
	private long id;
	
	private String titre;
	private String artiste;
	
	@ManyToMany(fetch = FetchType.EAGER)
	private Collection<User>users;
	
	
	


	public Track() {
		
	}
	

	public Track(long id, String titre, String artiste) {
	
		this.id = id;
		this.titre = titre;
		this.artiste = artiste;
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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


	public Collection<User> getUsers() {
		return users;
	}


	 public void setUsers(Collection<User> users) {
			this.users = users;
		}

	
	

}
