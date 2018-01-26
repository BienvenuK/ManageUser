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
import javax.persistence.ManyToMany;



@ManagedBean
@RequestScoped

@Entity
public class User implements Serializable {

private static final long serialVersionUID = 1L;
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    
	private String  nom;
    private String prenom;
    private String email;
    private String motPasse;
    @ManyToMany(mappedBy="users",fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    private Collection<Track> tracks;
   
    
    
    public void setTracks(Collection<Track> tracks) {
		this.tracks = tracks;
	}


	public Collection<Track> getTracks() {
		return tracks;
	}


	


	public User(long id, String nom, String prenom, String email, String motPasse) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.motPasse = motPasse;
	
	}
    
    
	public User() {
		
	}


	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMotPasse() {
		return motPasse;
	}
	public void setMotPasse(String motPasse) {
		this.motPasse = motPasse;
	}
	
	
	
	

}
