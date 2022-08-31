package nl.recepten.app.persistence;

import org.springframework.data.repository.CrudRepository;

import nl.recepten.app.model.RecipeIngredient;

public interface RecipeIngredientRepository extends CrudRepository <RecipeIngredient, Long>{

}
