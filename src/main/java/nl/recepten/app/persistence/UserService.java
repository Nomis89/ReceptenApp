package nl.recepten.app.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nl.recepten.app.model.User;

@Service
public class UserService {
	@Autowired
	UserRepository g;
	
	public Iterable<User> giveAllUsers(){
		return g.findAll();
	}

	public void saveUser(User gebruiker) {
		g.save(gebruiker);
		
	}

	public void deleteUser(long gebruikerid) {
		// TODO Auto-generated method stub
		g.deleteById(gebruikerid);
	}
	

}
