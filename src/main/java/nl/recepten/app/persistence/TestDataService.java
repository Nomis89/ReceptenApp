package nl.recepten.app.persistence;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nl.recepten.app.model.Ingredient;
import nl.recepten.app.model.KitchenAppliance;
import nl.recepten.app.model.QuantityType;
import nl.recepten.app.model.Recept;
import nl.recepten.app.model.RecipeIngredient;


@Service
public class TestDataService {

	@Autowired
	ReceptRepository rr;
	
	@Autowired
	IngredientRepository ir;
	
	@Autowired
	RecipeIngredientRepository rir;
	
	public Recept pushPastaPesto() {
		Ingredient ingredient1 = new Ingredient();
		Ingredient ingredient2 = new Ingredient();
		
		RecipeIngredient recipeIngredient1 = new RecipeIngredient();
		RecipeIngredient recipeIngredient2 = new RecipeIngredient();
		
		Recept recipe = new Recept();
		ArrayList<RecipeIngredient> recipelist = new ArrayList<RecipeIngredient>();
		ArrayList<KitchenAppliance> kitchenappliances= new ArrayList<KitchenAppliance>();
		
		ingredient1.setName("Pasta");
		ingredient1 = ir.save(ingredient1);
		
		ingredient2.setName("Pesto");
		ingredient2 = ir.save(ingredient2);
//		System.out.println("ingredienten gemaakt");
		
		recipeIngredient1.setIngredient(ingredient1);
		recipeIngredient1.setAmountType(QuantityType.GRAM);
		recipeIngredient1.setAmount(240);
		recipeIngredient1.setRecipe(recipe);

		recipeIngredient2.setIngredient(ingredient2);
		recipeIngredient2.setAmountType(QuantityType.EETLEPEL);
		recipeIngredient2.setAmount(4);
		recipeIngredient2.setRecipe(recipe);
		
//		System.out.println("Alle recipeIngredients gemaakt");
		
		recipelist.add(recipeIngredient1);
		recipelist.add(recipeIngredient2);
		
		kitchenappliances.add(KitchenAppliance.BLENDER);
		kitchenappliances.add(KitchenAppliance.VIJZEL);
		
		recipe.setName("Pasta pesto");
		recipe.setInstructions("Kook de pasta volgens de instructies op de verpakking. "
				+ "Voeg de pesto toe aan de pasta en meng deze.");
		recipe.setCookingTime(20);
		recipe.setTotalPortions(4);
		recipe.setvegitarian(true);
		recipe.setIngredients(recipelist);
		recipe.setKitchenAppliance(kitchenappliances);
		
		recipe = rr.save(recipe);
		
		recipeIngredient1 = rir.save(recipeIngredient1);
		recipeIngredient2 = rir.save(recipeIngredient2);
//		System.out.println("recept gemaakt");
		return recipe;
	}
	
	public Recept pushCrackerMetKaas() {
		
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
//		System.out.println("ingredienten gemaakt");

		recipeIngredient1.setIngredient(ingredient1);
		recipeIngredient1.setAmountType(QuantityType.STUK);
		recipeIngredient1.setAmount(1);
		recipeIngredient1.setRecipe(recipe);

		recipeIngredient2.setIngredient(ingredient2);
		recipeIngredient2.setAmountType(QuantityType.SNEE);
		recipeIngredient2.setAmount(2);
		recipeIngredient2.setRecipe(recipe);
//		System.out.println("Alle recipeIngredients gemaakt");

		recipelist.add(recipeIngredient1);
		recipelist.add(recipeIngredient2);

		recipe.setName("Cracker met kaas");
		recipe.setInstructions("Haal de cracker uit de verpakking. "
				+ "Snij twee plakjes kaas en leg deze op de cracker");
		recipe.setCookingTime(5);
		recipe.setTotalPortions(1);
		recipe.setvegitarian(true);
		recipe.setIngredients(recipelist);
		
		recipe = rr.save(recipe);
		
		recipeIngredient1 = rir.save(recipeIngredient1);
		recipeIngredient2 = rir.save(recipeIngredient2);
//		System.out.println("recept gemaakt");
		return recipe;
	}
	
	public void createRecipeHevainUser() {
		
	}
}
