package nl.recepten.app.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import nl.recepten.app.model.RecipeIngredient;
import nl.recepten.app.persistence.RecipeIngredientService;

@RestController
public class RecipeIngredientEndpoint {
	
	@Autowired
	RecipeIngredientService ris;
	
	@GetMapping("GetRecipyIngredient/{id}")
	public RecipeIngredient EndpointgetRecipeIngredientById(@PathVariable("id")long id) {
		//System.out.println();
		//int x;
		RecipeIngredient recipeIngredient = new RecipeIngredient();
		return ris.getRecipeIngredientById(id);
		
	}

}
