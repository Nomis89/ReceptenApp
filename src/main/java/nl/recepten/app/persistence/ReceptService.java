package nl.recepten.app.persistence;

import java.util.ArrayList;
import java.util.List;

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

	public Recept addRecipe(Recept recept) {
		return rr.save(recept);
		
	}

	public void deleteRecipe(long receptid) {
		 rr.deleteById(receptid);
	}
	
	public List<Recept> getRecipesWithIngredient(String ingredient){
		
		
		return new ArrayList<Recept>();
	}
	
}
