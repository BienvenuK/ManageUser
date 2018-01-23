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
	
	public void delete() {
		System.out.println(this.user.getId()+"utilisateur a supprimer");
		this.setUser(userDao.getUserByIdDao(user.getId()));
		userDao.deleteDao(this.user);
	}

	public User getUserById(long id) {
		return userDao.getUserByIdDao(id);
	}

	public  String showUser( long id) {

		User user = getUserById(id);
		this.user = user;
		return "showUser";
	}

	public String edit(long id) {
		User user = getUserById(id);
		this.user = user;
		System.out.println(user.getEmail());
		return "edit";

	}

	public String update(User user) {
		this.user = user;
		userDao.edit(this.user );

		return "ListeUsers";


	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}






}
