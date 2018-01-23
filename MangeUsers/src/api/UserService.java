package api;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import poe.user.User;
import poe.user.UserDao;


@Path("rest")
public class UserService {
	
	@EJB
	UserDao userDao;
	
	
	
	@GET
	@Produces("application/json")
	@Path("/show")
	public User show(@QueryParam("id") long id) {
		
	User user = userDao.getUserByIdDao(id);
		
		return user;
		
	}
	
	
	@POST
	@Produces("application/json")
	@Path("/add")
	public void add(@QueryParam("email") String email, @QueryParam("email") String password) {
		System.out.println("tomnkiugljkhb");
		User user = new User();
		user.setEmail(email);
		user.setMotPasse(password);
		userDao.addUserDao(user);
		
			
			
		}
	
	@GET
	@Produces("application/json")
	@Path("/ListUsers")
	public List<User> list() {
		
			return userDao.getUsersListDao();
			
			
		}
	
	@POST
	@Produces("application/json")
	@Path("/edit")
	public void edit(@QueryParam("id") long id, @QueryParam("email") String email,@QueryParam("password") String password) {
		
		User user = userDao.getUserByIdDao(id);
		user.setEmail(email);
		user.setMotPasse(password);
		userDao.edit(user);
			
			
		}
	
	@DELETE
	@Produces("application/json")
	@Path("/delete")
	public void edit(@QueryParam("id") long id) {
		
		User user = userDao.getUserByIdDao(id);
		
		userDao.deleteDao(user);
			
			
		}

}