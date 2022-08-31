package nl.recepten.app.persistence;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import nl.recepten.app.model.Ingredient;

@Component
public interface IngredientRepository extends CrudRepository<Ingredient, Long> {
	
	ArrayList<Ingredient> findByNameIgnoreCase(String name);
	
}
