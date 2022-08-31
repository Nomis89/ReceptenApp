package nl.recepten.app.persistence;



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
	
	public Ingredient serviceGetIngredientById(long id) {
		System.out.println("Hij doet het - service");
//		long id = 2;
		Ingredient ingredient = ir.findById(id).get();
		System.out.println(ingredient.getName());
		return ingredient;
	}
	

	
}
