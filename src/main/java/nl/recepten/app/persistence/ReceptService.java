package nl.recepten.app.persistence;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nl.recepten.app.model.Ingredient;
import nl.recepten.app.model.Recept;
import nl.recepten.app.model.RecipeIngredient;
import nl.recepten.app.model.User;

@Service
public class ReceptService {
	@Autowired
	ReceptRepository rr;
	
	@Autowired
	IngredientService is;
	
	@Autowired
	RecipeIngredientRepository rir;
	
	public void receptService() {
		System.out.println("We zitten in de service");
		rr.save(new Recept());
	}
	public Recept getRecept(long id) {
		Recept recept = rr.findById(id).get();
		
		return recept;
		
	}
	
	public Iterable<Recept> findAllRecipes() {
		return rr.findAll();
	}

	public Recept addRecipe(Recept recept) {
		return rr.save(recept);
		
	}

	public void deleteRecipe(long receptid) {
		 rr.deleteById(receptid);
	}
	
	public HashMap<Recept, Double> RecipesBasedOnIngredientsAsIngredients(ArrayList<Ingredient> ingredients){
		
		Recept recipe;
		ArrayList<RecipeIngredient> recipeIngredients = new ArrayList<RecipeIngredient>();
		HashMap<Recept, Integer> recipeOccurance = new HashMap<Recept, Integer>();
		Set<Recept> recepten;
		HashMap<Recept, Double> recipePercentage = new HashMap<Recept, Double>();
		
		for (Ingredient i : ingredients) {
			recipeIngredients = rir.findByIngredient(i);
			for (RecipeIngredient ri : recipeIngredients) {
				recipe = ri.getRecipe();
				if (!recipeOccurance.containsKey(recipe)) {
					recipeOccurance.put(recipe, 1);
				} else {
					recipeOccurance.put(recipe, recipeOccurance.get(recipe) + 1);
				}
				System.out.println(recipe.getName());
			}
		}
		
		recepten = recipeOccurance.keySet();
		for (Recept r: recepten) {
			System.out.println("recipe name: " + r.getName() + " - occurances: " + Integer.toString(recipeOccurance.get(r)));
		}
		
		for (Recept r: recepten) {
			recipePercentage.put(r, (double) recipeOccurance.get(r) / r.getIngredients().size());
		}
		return recipePercentage;
	}
	
	public HashMap<Recept, Double> recipesBasedOnIngredientsAsString(ArrayList<String> ingredients){
		
		ArrayList<Ingredient> ingredientAsList = new ArrayList<Ingredient>();
		for (String i : ingredients) {
			ingredientAsList.add(is.checkExistenceOrCreate(i));
		}
		return RecipesBasedOnIngredientsAsIngredients(ingredientAsList);
	}
	
	public Recept updateRecipe(Recept recept) {
		Recept recept2 = rr.findById(recept.getId()).get();
		recept2.setName(recept.getName());
		recept2.setInstructions(recept.getInstructions());
		recept2.setCookingTime(recept.getCookingTime());
		recept2.setTotalPortions(recept.getTotalPortions());
		rr.save(recept2);
		return recept2;
	}

}
