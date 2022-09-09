package nl.recepten.app.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import nl.recepten.app.model.Account;
import nl.recepten.app.model.User;
import nl.recepten.app.persistence.AccountService;
import nl.recepten.app.persistence.UserService;

@RestController
public class UserEndpoint {
	
	@Autowired
	AccountService as;
	
	@Autowired
	UserService gs;
	
	@GetMapping("/test1")
	public Iterable<User> allUsers() {
		System.out.println("it works");
		return gs.giveAllUsers();
	}
	
	@GetMapping("getUser/{id}")
	public User getUserById(@PathVariable("id")long accountId){
		
		Account loggedInAccount = as.accountSession(accountId);
		User loggedInUser = loggedInAccount.getUser();
		return loggedInUser;
	}
	
	@PostMapping("adduser")
	public void addUser(@RequestBody User gebruiker) {
		System.out.println(gebruiker.getName());
		gs.saveUser(gebruiker);
	}
	
	@DeleteMapping("deleteuser/{gebruikerid}")
	public void deleteUser(@PathVariable("gebruikerid") int gebruikerid){
		gs.deleteUser(gebruikerid);
	}
	
}
