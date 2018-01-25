package poe.user;

import java.io.Serializable;
import java.lang.ProcessBuilder.Redirect;
import java.util.ArrayList;
import java.util.Collection;
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
	private Track track;

	@EJB
	UserDao userDao;
	@EJB
	TrackDao trackDao;

	public UserController() {
		user = new User();
		track = new Track();
	}

	public String add(User user) {

		userDao.addUserDao(user);
		return "ListeUsers";
	}

	public List<User> getUsersList() {
		return userDao.getUsersListDao();
	}

	public void delete(User user) {
		userDao.deleteDao(user);
	}

	public void delete() {
		System.out.println(this.user.getId() + "utilisateur a supprimer");
		this.setUser(userDao.getUserByIdDao(user.getId()));
		userDao.deleteDao(this.user);
	}

	public User getUserById(long id) {
		System.out.println(id);
		return userDao.getUserByIdDao(id);
	}

	public Collection<Track> getTracksForUserById() {
		System.out.println(user.getId());
		return userDao.getUserByIdDao(user.getId()).getTracks();
	}
	
	public String showUser(long id) {

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
		userDao.edit(this.user);

		return "ListeUsers";

	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void addTrackToUser(long idUser, long idTrack) {
		User user = userDao.getUserByIdDao(idUser);
		this.user = user;
		System.out.println(idTrack + "je suis ");
		Track track = trackDao.getTrackById(idTrack);
		this.user.getTracks().add(track);
		userDao.edit(user);
	}

	public Collection<Track> tracksUser(long id) {
		if (this.user.getTracks() == null) {
			Collection<Track> tracks = new ArrayList<>();

		} else {
			this.user.getTracks();

		}
		return this.user.getTracks();

	}
}