package nl.recepten.app.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import nl.recepten.app.model.Recept;
import nl.recepten.app.persistence.ReceptService;

@RestController
public class ReceptEndpoint {
	
	@Autowired
	ReceptService rs;
	
	@GetMapping("pushRecipe")
	public Iterable<Recept> addRecipe () {
		return rs.getAllRecipes();
	}
	
	@PostMapping("addRecipe")
	public void addRecipe(@RequestBody Recept recept) {
		System.out.println("Check 1,2,3");
	}
	
}
