package nl.recepten.app.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import nl.recepten.app.model.Ingredient;
import nl.recepten.app.model.Recept;
import nl.recepten.app.model.RecipeIngredient;
import nl.recepten.app.persistence.IngredientRepository;
import nl.recepten.app.persistence.ReceptRepository;
import nl.recepten.app.persistence.RecipeIngredientRepository;
import nl.recepten.app.persistence.RecipeIngredientService;

@RestController
public class RecipeIngredientEndpoint {
	
	@Autowired
	RecipeIngredientService ris;
	
	@Autowired
	private RecipeIngredientRepository rir;
	
	@Autowired
	ReceptRepository rr;
	
	@Autowired
	IngredientRepository ir;
	
//	@GetMapping("GetRecipeIngredient/{id}")
//	public RecipeIngredient EndpointgetRecipeIngredientById(@PathVariable("id")long id) {
//
//		//System.out.println();
//		//int x;
//		RecipeIngredient recipeIngredient = new RecipeIngredient();
//		return ris.getRecipeIngredientById(id);
//		
//	}
//	
	@PostMapping("SetRecipeIngredient/{recipeId}/{ingredientId}")
	public void addRecipeIngredient(@RequestBody RecipeIngredient recipe_ingredient, 
			@PathVariable long recipeId, @PathVariable long ingredientId) {
		RecipeIngredient ri = new RecipeIngredient();
		Recept recept = rr.findById(recipeId).get();
		Ingredient ingredient = ir.findById(ingredientId).get();
		recipe_ingredient.setRecept(recept);
		System.out.println(recipe_ingredient.getAmount());
		recipe_ingredient.setIngredient(ingredient);
		
		rir.save(recipe_ingredient);
		
	}
	}
