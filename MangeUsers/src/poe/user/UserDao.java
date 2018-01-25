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
	
	public List<User> getUsersListDao(){
		
		 CriteriaBuilder lCriteriaBuilder = em.getCriteriaBuilder();
       CriteriaQuery<User> lCriteriaQuery = lCriteriaBuilder.createQuery(User.class);
      Root<User> lRoot = lCriteriaQuery.from(User.class);
        lCriteriaQuery.select(lRoot);
       TypedQuery<User> lTypedQuery = em.createQuery(lCriteriaQuery);
        return lTypedQuery.getResultList();
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
	
	
}
