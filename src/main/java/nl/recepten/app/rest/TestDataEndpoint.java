package nl.recepten.app.rest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import nl.recepten.app.model.Ingredient;
import nl.recepten.app.model.Recept;
import nl.recepten.app.model.User;
import nl.recepten.app.persistence.IngredientRepository;
import nl.recepten.app.persistence.IngredientService;
import nl.recepten.app.persistence.ReceptService;
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
	
	@Autowired
	ReceptService rs;
	
	@GetMapping("PushTestData")
	public void PushTestData() {
		User user = tds.createRecipeHavingUser();
		User user2 = tds.createStockHavingUser();
		Recept recipe1 = tds.pushPastaPesto(user);
		Recept recipe2 = tds.pushPastaPestoKaas(user);
		Recept recipe3 = tds.pushCrackerMetKaas(user);
	}
	
	@GetMapping("TestFindingAllRecipesByString")
	public void TestFindingRecipesWithStrings() {
		Set<Recept> receptenpercentage;
		ArrayList<String> ingredients = new ArrayList<String>();
		ingredients.add("Kaas");
		ingredients.add("Pesto");
		PushTestData();
		HashMap<Recept, Double> recipePercentage = rs.recipesBasedOnIngredientsAsString(ingredients);
		
		receptenpercentage = recipePercentage.keySet();
		for (Recept r: receptenpercentage) {
			System.out.println("recipe name: " + r.getName() + " - occurances: " + Double.toString(recipePercentage.get(r)));
		}
	}
	
	@GetMapping("TestFindingAllRecipesByIngredients")
	public void TestFindingRecipesWithIngredients() {
		Set<Recept> receptenpercentage;
		
		PushTestData();
		Ingredient ingredient1 = is.checkExistenceOrCreate("Kaas");
		Ingredient ingredient2 = is.checkExistenceOrCreate("Pesto");
		
		ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>();
		ingredients.add(ingredient1);
		ingredients.add(ingredient2);

		HashMap<Recept, Double> recipePercentage = rs.RecipesBasedOnIngredientsAsIngredients(ingredients);
		
		receptenpercentage = recipePercentage.keySet();
		for (Recept r: receptenpercentage) {
			System.out.println("recipe name: " + r.getName() + " - occurances: " + Double.toString(recipePercentage.get(r)));
		}
	}
}
