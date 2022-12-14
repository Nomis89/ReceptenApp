package nl.recepten.app.persistence;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import nl.recepten.app.model.Ingredient;
import nl.recepten.app.model.Recept;
import nl.recepten.app.model.RecipeIngredient;

public interface RecipeIngredientRepository extends CrudRepository 
		<RecipeIngredient, Long>{
	ArrayList<RecipeIngredient> findByIngredient(Ingredient ingredient);
	Iterable<RecipeIngredient> findByrecept(Recept recipe);

}
