package nl.recepten.app.rest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import nl.recepten.app.model.Ingredient;
import nl.recepten.app.persistence.IngredientService;

@RestController
public class IngredientEndpoint {

		@Autowired
		IngredientService is;
		
		@GetMapping("returnIngredients")
		public  Iterable<Ingredient> returnIngredients() {
			System.out.println("returnIngredients");
			return is.giveAllIngredients();
		}
		
		@GetMapping("getIngredient/{id}")
		public Ingredient getIngredientById(@PathVariable("id")long id) {
			System.out.println("Hij doet het W");
			int x;
			Ingredient ingredient = new Ingredient();
//			ingredient.setId(28);
			return is.serviceGetIngredientById(id);
//			return ingredient;
		}
		

}
