package poe.user;

import java.io.Serializable;
import java.lang.ProcessBuilder.Redirect;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.transaction.Transactional;

import org.omg.CORBA.Request;

@ManagedBean
@RequestScoped
public class UserController implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private User user;
	
	@EJB
	UserDao userDao;
	
	public UserController() {
		 user = new  User();
	}
	
	public String add(User user) {
		
		userDao.addUserDao(user);
		return "ListeUsers";
	}
	
	public List<User> getUsersList(){
		return userDao.getUsersListDao();
	}
	
	public void delete(User user) {
		userDao.deleteDao(user);
	}
	
	public User getUserById(long id) {
	return userDao.getUserByIdDao(id);
	}
	
	public  String showUser( long id) {
	User user = getUserById(id);
		
		return "showUser?user="+user;
	}
	
//	public void edit(User user) {
//		
//		
//		
//	}

	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	
	
	
	

}
