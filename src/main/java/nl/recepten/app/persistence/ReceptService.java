package nl.recepten.app.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nl.recepten.app.model.Recept;

@Service
public class ReceptService {
	@Autowired
	ReceptRepository rr;
	
	public void receptService() {
		System.out.println("We zitten in de service");
		rr.save(new Recept());
	}
	
	public Iterable<Recept> findAllRecipes() {
		return rr.findAll();
	}

	public void addRecipe(Recept recept) {
		rr.save(recept);
	}

	public void deleteRecipe(long receptid) {
		 rr.deleteById(receptid);
	}
	
}
