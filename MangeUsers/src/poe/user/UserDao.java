package poe.user;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class UserDao  {
	
	@PersistenceContext(unitName="pu-h2")
	private EntityManager em;
	
	public  void  addUserDao(User user) {
		System.out.println("utilisateur " + user.toString());
		em.persist(user);
		
	}
	
	

	

}
