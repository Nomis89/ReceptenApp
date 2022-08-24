package nl.recepten.app.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nl.recepten.app.model.Gebruiker;

@Service
public class GebruikerService {
	@Autowired
	GebruikerRepository g;
	
	public void ietsOpslaan() {
		g.save(new Gebruiker());
	}
	
	public void saveNewUser(String newUser) {
		Gebruiker user1 = new Gebruiker();
		user1.setName(newUser);
		g.save(user1);
	}

}
