package nl.recepten.app.persistence;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nl.recepten.app.model.Ingredient;

@Service
public class IngredientService {
	@Autowired
	IngredientRepository ir;
	
	public Iterable<Ingredient> giveAllIngredients(){
		return ir.findAll();
	}
	
	public Ingredient checkExistenceOrCreate(String ingredientName) {
		ArrayList<Ingredient> ingredientList = ir.findByNameIgnoreCase(ingredientName);
		Ingredient ingredient = new Ingredient();
		if (ingredientList.size() == 0) {
			ingredient.setName(ingredientName);
			System.out.println("Ingredient " + ingredientName + " Does not exist");
			ir.save(ingredient);
			return ingredient;
		} else {
			System.out.println("Ingredient " + ingredientName + " Does exist");
			return ingredientList.get(0);
		}
	}
	
	public Ingredient serviceGetIngredientById(long id) {
		System.out.println("Hij doet het - service");
//		long id = 2;
		Ingredient ingredient = ir.findById(id).get();
		System.out.println(ingredient.getName());
		return ingredient;
	}
	
}
