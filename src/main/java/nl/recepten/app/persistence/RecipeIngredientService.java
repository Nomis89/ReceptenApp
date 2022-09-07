package nl.recepten.app.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nl.recepten.app.model.RecipeIngredient;

@Service
public class RecipeIngredientService {
	
	@Autowired
	RecipeIngredientRepository rir;
	
	public Iterable<RecipeIngredient> findAllRecipeIngredients(){
			return rir.findAll();
	}

	public RecipeIngredient getRecipeIngredientById(long id) {
		System.out.println("It works");
		RecipeIngredient recipeIngredient = rir.findById(id).get();
		System.out.println(recipeIngredient.getIngredient());
		return recipeIngredient;
	}
	
	public void setRecipeIngredient(long id, long[] ingredientIdArray) {
		for(long i : ingredientIdArray) {
			rir.addRecipeIngredient(id, i);
		}
		
	}
}
