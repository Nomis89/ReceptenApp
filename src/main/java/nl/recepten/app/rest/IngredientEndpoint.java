package nl.recepten.app.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import nl.recepten.app.model.Ingredient;
import nl.recepten.app.persistence.IngredientService;

@RestController
public class IngredientEndpoint {

		@Autowired
		IngredientService is;
		
		@GetMapping("returnIngredients")
		public  Iterable<Ingredient> returnIngredients() {
			return is.giveAllIngredients();
		}
		
		@GetMapping("getIngredient/{id}")
		public Ingredient getIngredientById(@PathVariable("id")long id) {
			return is.serviceGetIngredientById(id);

		}
		
		@PostMapping("setIngredient/{name}")
		public long checkExistenceOrCreate(@PathVariable("name")String ingredient_name) {
			return is.checkExistenceOrCreate(ingredient_name).getId();
		}

}
