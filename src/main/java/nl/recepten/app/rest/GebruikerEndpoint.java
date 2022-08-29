package nl.recepten.app.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import nl.recepten.app.model.Gebruiker;
import nl.recepten.app.persistence.GebruikerService;

@RestController
public class GebruikerEndpoint {
		
	@Autowired
		GebruikerService gs;
	
	@GetMapping("/test1")
	public Iterable<Gebruiker> allUsers() {
		System.out.println("it works");
		return gs.giveAllUsers();
	}
	
	@PostMapping("adduser")
	public void addUser(@RequestBody Gebruiker gebruiker) {
		System.out.println(gebruiker.getName());
		gs.saveUser(gebruiker);
	}
	
	@DeleteMapping("deleteuser/{gebruikerid}")
	public void deleteUser(@PathVariable("gebruikerid") int gebruikerid){
		gs.deleteUser(gebruikerid);
	}
	
}
