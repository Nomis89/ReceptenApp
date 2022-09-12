package nl.recepten.app.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nl.recepten.app.model.Ingredient;
import nl.recepten.app.model.Recept;
import nl.recepten.app.model.RecipeIngredient;

@Service
public class RecipeIngredientService {
	
	@Autowired
	private RecipeIngredientRepository rir;
	
	@Autowired
	private IngredientRepository ir;
	
	@Autowired
	private ReceptRepository rr;
	
	public Iterable<RecipeIngredient> findAllRecipeIngredients(){
			return rir.findAll();
	}

	public RecipeIngredient getRecipeIngredientById(long id) {
		System.out.println("It works");
		RecipeIngredient recipeIngredient = rir.findById(id).get();
		System.out.println(recipeIngredient.getIngredient());
		return recipeIngredient;
	}
	
	public void addRecipeIngredient(RecipeIngredient recipe_ingredient, long recipeId, 
			long ingredientId) {
		rir.save(recipe_ingredient);
		
	}
}		

