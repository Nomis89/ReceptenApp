package nl.recepten.app.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
}
