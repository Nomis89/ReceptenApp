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
	
}
