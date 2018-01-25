package poe.user;

import java.util.Collection;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

@Stateless
public class TrackDao {
	
	@PersistenceContext(unitName="pu-h2")
	private EntityManager em; 
	
	public long addTrackDao(Track track) {
		em.persist(track);
		return track.getId();
	}
	
	public Collection<Track> getTracksListDao(){
		 CriteriaBuilder lCriteriaBuilder = em.getCriteriaBuilder();
	       CriteriaQuery<Track> lCriteriaQuery = lCriteriaBuilder.createQuery(Track.class);
	      Root<Track> lRoot = lCriteriaQuery.from(Track.class);
	        lCriteriaQuery.select(lRoot);
	       TypedQuery<Track> lTypedQuery = em.createQuery(lCriteriaQuery);
	        return lTypedQuery.getResultList();
	}
	
	public Track getTrackById(long id) {
		return em.find(Track.class, id);
	}
	
	@Transactional
	public void delete(long trackId) {
		Track track = em.find(Track.class, trackId);
		em.remove(em.contains(track) ? track : em.merge(track));
	}
	
	
	public  void edit (Track track) {
		em.merge(track);
	}

}
