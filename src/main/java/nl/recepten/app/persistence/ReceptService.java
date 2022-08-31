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
	
	public void PushRecipeTestData() {
		Recept recipe1 = new Recept();
		recipe1.setName("Pasta pesto");
		recipe1.setInstructions("Kook de pasta volgens de instructies op de verpakking. "
				+ "Voeg de pesto toe aan de pasta en meng deze.");
		recipe1.setCookingTime(20);
		recipe1.setTotalPortions(4);
		recipe1.setvegitarian(true);
		
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
