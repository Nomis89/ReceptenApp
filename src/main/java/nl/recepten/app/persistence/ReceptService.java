package nl.recepten.app.persistence;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nl.recepten.app.model.Ingredient;
import nl.recepten.app.model.QuantityType;
import nl.recepten.app.model.Recept;
import nl.recepten.app.model.RecipeIngredient;

@Service
public class ReceptService {
	@Autowired
	ReceptRepository rr;
	
	@Autowired
	IngredientRepository ir;
	
	@Autowired
	RecipeIngredientRepository rir;
	
	public void receptService() {
		System.out.println("We zitten in de service");
		rr.save(new Recept());
	}
	
	public void pushPastaPesto() {
		Ingredient ingredient1 = new Ingredient();
		Ingredient ingredient2 = new Ingredient();
		
		RecipeIngredient recipeIngredient1 = new RecipeIngredient();
		RecipeIngredient recipeIngredient2 = new RecipeIngredient();
		
		Recept recipe = new Recept();
		ArrayList<RecipeIngredient> recipelist = new ArrayList<RecipeIngredient>();
		
		ingredient1.setName("Pasta");
		ingredient1 = ir.save(ingredient1);
		
		ingredient2.setName("Pesto");
		ingredient2 = ir.save(ingredient2);
		
		recipeIngredient1.setIngredient(ingredient1);
		recipeIngredient1.setAmountType(QuantityType.GRAM);
		recipeIngredient1.setAmount(240);
		recipeIngredient1 = rir.save(recipeIngredient1);
		
		recipeIngredient2.setIngredient(ingredient1);
		recipeIngredient2.setAmountType(QuantityType.EETLEPEL);
		recipeIngredient2.setAmount(4);
		recipeIngredient2 = rir.save(recipeIngredient1);
		
		recipe.setName("Pasta pesto");
		recipe.setInstructions("Kook de pasta volgens de instructies op de verpakking. "
				+ "Voeg de pesto toe aan de pasta en meng deze.");
		recipe.setCookingTime(20);
		recipe.setTotalPortions(4);
		recipe.setvegitarian(true);
		recipelist.add(recipeIngredient1);
		recipelist.add(recipeIngredient2);
		recipe.setIngredients(recipelist);
		rr.save(recipe);
	}
	
	public void pushCrackerMetKaas() {
	
		Ingredient ingredient1 = new Ingredient();
		Ingredient ingredient2 = new Ingredient();

		RecipeIngredient recipeIngredient1 = new RecipeIngredient();
		RecipeIngredient recipeIngredient2 = new RecipeIngredient();

		Recept recipe = new Recept();
		ArrayList<RecipeIngredient> recipelist = new ArrayList<RecipeIngredient>();
		
		ingredient1.setName("Cracker");
		ingredient1 = ir.save(ingredient1);
		
		ingredient2.setName("Kaas");
		ingredient2 = ir.save(ingredient2);

		recipeIngredient1.setIngredient(ingredient1);
		recipeIngredient1.setAmountType(QuantityType.STUK);
		recipeIngredient1.setAmount(1);
		recipeIngredient1 = rir.save(recipeIngredient1);
		
		recipeIngredient2.setIngredient(ingredient2);
		recipeIngredient2.setAmountType(QuantityType.SNEE);
		recipeIngredient2.setAmount(2);
		recipeIngredient2 = rir.save(recipeIngredient2);

		recipe.setName("Cracker met kaas");
		recipe.setInstructions("Haal de cracker uit de verpakking. "
				+ "Snij twee plakjes kaas en leg deze op de cracker");
		recipe.setCookingTime(5);
		recipe.setTotalPortions(1);
		recipe.setvegitarian(true);
		recipelist.add(recipeIngredient1);
		recipelist.add(recipeIngredient2);
		recipe.setIngredients(recipelist);
		
		rr.save(recipe);
	}
	
	public Iterable<Recept> findAllRecipes() {
		return rr.findAll();
	}

	public void addRecipe(Recept recept) {
		rr.save(recept);
		
	}
	
}
