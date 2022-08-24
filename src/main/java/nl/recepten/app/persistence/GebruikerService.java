package nl.recepten.app.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nl.recepten.app.model.Gebruiker;

@Service
public class GebruikerService {
	@Autowired
	GebruikerRepository g;
	
	public Iterable<Gebruiker> giveAllUsers(){
		return g.findAll();
	}

	public void saveUser(Gebruiker gebruiker) {
		g.save(gebruiker);
		
	}

	public void deleteUser(long gebruikerid) {
		// TODO Auto-generated method stub
		g.deleteById(gebruikerid);
	}
	

}
