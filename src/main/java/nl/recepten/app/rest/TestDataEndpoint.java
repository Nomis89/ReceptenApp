package nl.recepten.app.rest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import nl.recepten.app.model.Ingredient;
import nl.recepten.app.model.Recept;
import nl.recepten.app.model.RecipeIngredient;
import nl.recepten.app.model.User;
import nl.recepten.app.persistence.IngredientRepository;
import nl.recepten.app.persistence.IngredientService;
import nl.recepten.app.persistence.RecipeIngredientRepository;
import nl.recepten.app.persistence.TestDataService;

@RestController
public class TestDataEndpoint {

	@Autowired
	TestDataService tds;
	
	@Autowired
	IngredientRepository ir;
	
	@Autowired
	IngredientService is;
	
	@Autowired
	RecipeIngredientRepository rir;
	
	@GetMapping("PushTestData")
	public void PushTestData() {
		User user = tds.createRecipeHavingUser();
		User user2 = tds.createStockHavingUser();
		Recept recipe1 = tds.pushPastaPesto(user);
		Recept recipe2 = tds.pushPastaPestoKaas(user);
		Recept recipe3 = tds.pushCrackerMetKaas(user);
	}
	
	@GetMapping("TestFindingAllRecipesByIngredient")
	public void TestFindingRecipes() {
		PushTestData();
		String[] ingredients = {"Kaas", "Pesto"};
		HashMap<Recept, Integer> recipeOccurance = new HashMap<Recept, Integer>();
		for (String i : ingredients) {
			Ingredient ingredient = is.checkExistenceOrCreate(i);
			ArrayList<RecipeIngredient> recipeIngredients = rir.findByingredient(ingredient);
			for (RecipeIngredient ri : recipeIngredients) {
				Recept recipe = ri.getRecipe();
				if (!recipeOccurance.containsKey(recipe)) {
					recipeOccurance.put(recipe, 1);
				} else {
					recipeOccurance.put(recipe, recipeOccurance.get(recipe) + 1);
				}
				System.out.println(recipe.getName());
			}
		}
		Set<Recept> recepten = recipeOccurance.keySet();
		for (Recept r: recepten) {
			System.out.println("recipe name: " + r.getName() + " occurances: " + Integer.toString(recipeOccurance.get(r)));
		}
		HashMap<Recept, Double> recipePercentage = new HashMap<Recept, Double>();
		for (Recept r: recepten) {
			recipePercentage.put(r, (double) recipeOccurance.get(r) / r.getIngredients().size());
		}
		Set<Recept> receptenpercentage = recipePercentage.keySet();
		for (Recept r: receptenpercentage) {
			System.out.println("recipe name: " + r.getName() + " occurances: " + Double.toString(recipePercentage.get(r)));
		}
	}
}
