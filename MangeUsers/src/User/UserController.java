package User;

import java.io.Serializable;
import java.lang.ProcessBuilder.Redirect;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.omg.CORBA.Request;

@ManagedBean()
@RequestScoped
public class UserController<HttpSession, HttpServletRequest> implements Serializable {
	
	    private static final long serialVersionUID = 1L;
	
	
	private User user;
	Request request;
	
	
	
	
	
	
	
	
	
	
	
	
	public UserController() {
		 user = new  User();
	
	}







	public String show() {
		
		
		System.out.println(user.getNom() + " "+ user.getPrenom() + " " + user.getEmail() );
		return "home";
		
		
	}



	



	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}
	
	
	
	
	

}
