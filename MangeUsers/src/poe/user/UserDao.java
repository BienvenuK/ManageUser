package poe.user;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;


@Stateless
public class UserDao  {
	@EJB
	TrackDao trackDao;
	private UserController userController;
	
	@PersistenceContext(unitName="pu-h2")
	private EntityManager em;
	
	public  void  addUserDao(User user) {
		System.out.println("utilisateur " + user.toString());
		em.persist(user);
	}
	
	@SuppressWarnings("unchecked")
	public List<User> getUsersListDao(){
		
		 return em.createQuery("select e from User e").getResultList();
	}
	
	
	
	public User getUserByIdDao(long id) {
		return em.find(User.class,id);
	}
	
		
	@Transactional
	public void deleteDao(User user) {
		em.remove(em.contains(user) ? user : em.merge(user));
	}
	
	
	public  void edit (User user) {
		em.merge(user);
	}
	
	public void addTrackToUserDao(long userId , long trackId) {
		 User user = getUserByIdDao(userId);
	        Track track = trackDao.getTrackById(trackId);
	        user.getTracks().add(track);
	        track.getUsers().add(user);
	        System.out.println("user tracks + " + user.getTracks().size());
	        em.persist(user);
	        System.out.println("user tracks + " + user.getTracks().size());
		
		
		
		
	}
	
	public void deleteTrackFromUser(long idUser, long idTrack) {
		
		User user = getUserByIdDao(idUser);
		Track track = trackDao.getTrackById(idTrack);
		user.getTracks().remove(track);
		track.getUsers().remove(user);
		em.persist(user);
		
	}
	
	
}
