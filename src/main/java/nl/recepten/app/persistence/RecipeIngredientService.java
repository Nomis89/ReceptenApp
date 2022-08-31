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
}
