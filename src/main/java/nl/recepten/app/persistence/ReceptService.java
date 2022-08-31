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
		
		
		Recept recipe2 = new Recept();
		recipe2.setName("Cracker met kaas");
		recipe2.setInstructions("Haal de cracker uit de verpakking. "
				+ "Snij twee plakjes kaas en leg deze op de cracker");
		recipe2.setCookingTime(5);
		recipe2.setTotalPortions(1);
		recipe2.setvegitarian(true);
		
		
		
		
	}
	
}
