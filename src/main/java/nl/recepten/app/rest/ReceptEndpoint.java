package nl.recepten.app.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import nl.recepten.app.model.Recept;
import nl.recepten.app.model.User;
import nl.recepten.app.persistence.ReceptService;

@RestController
public class ReceptEndpoint {
	
	@Autowired
	ReceptService rs;
	
	@GetMapping("findAllRecipes")
	public Iterable<Recept> findAllRecipes() {
		return rs.findAllRecipes();
	}
	@GetMapping("getRecipe/{id}")
	public Recept getReceptById(@PathVariable("id")long id){
		//User user = new User();
		return rs.getRecept(id);
	}
	@PostMapping("addRecipe")
	public long addRecipe(@RequestBody Recept recept) {
		return rs.addRecipe(recept).getId();
	}
	
	@DeleteMapping("deleteRecipe/{receptid}")
	public void deleteRecipe(@PathVariable("receptid") int receptid) {
		rs.deleteRecipe(receptid);
	}
	
	
}
