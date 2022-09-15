package nl.recepten.app.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import nl.recepten.app.model.Account;
import nl.recepten.app.model.Recept;
import nl.recepten.app.model.User;
import nl.recepten.app.persistence.AccountService;
import nl.recepten.app.persistence.ReceptService;

@RestController
public class ReceptEndpoint {
	
	@Autowired
	ReceptService rs;
	
	@Autowired
	AccountService as;
	
	@GetMapping("findAllRecipes")
	public Iterable<Recept> findAllRecipes() {
		return rs.findAllRecipes();
	}
	@GetMapping("getRecipe/{id}")
	public Recept getReceptById(@PathVariable("id")long id){
		//User user = new User();
		return rs.getRecept(id);
	}
	@PostMapping("addRecipe/{accountId}")
	public long addRecipe(@RequestBody Recept recept, @PathVariable("accountId") long id) {
		Account account = as.accountSession(id);
		User user = account.getUser();
		recept.setUser(user);
		rs.addRecipe(recept);
		return recept.getId();
	}
	
	@DeleteMapping("deleteRecipe/{receptid}")
	public void deleteRecipe(@PathVariable("receptid") int receptid) {
		rs.deleteRecipe(receptid);
	}
	
	@PutMapping("updateRecipe/{receptid}")
	public Recept updateRecipe(@PathVariable("receptid")int rid, @RequestBody Recept recept) {
//		System.out.println("ja we zijn binnen" + recept.getName());
		return rs.updateRecipe(recept);
	}

	
}
