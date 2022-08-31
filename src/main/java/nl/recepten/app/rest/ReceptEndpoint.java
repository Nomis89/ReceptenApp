package nl.recepten.app.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import nl.recepten.app.model.Recept;
import nl.recepten.app.persistence.ReceptService;

@RestController
public class ReceptEndpoint {
	
	@Autowired
	ReceptService rs;
	
	@GetMapping("findAllRecipes")
	public Iterable<Recept> findAllRecipes() {
		return rs.findAllRecipes();
	}
	
	@PostMapping("addRecipe")
	public void addRecipe(@RequestBody Recept recept) {
		rs.addRecipe(recept);
	}
	
	@DeleteMapping("deleteRecipe/{receptid}")
	public void deleteRecipe(@PathVariable("receptid") int receptid) {
		rs.deleteRecipe(receptid);
	}
	
	
}
