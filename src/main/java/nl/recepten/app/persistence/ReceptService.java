package nl.recepten.app.persistence;

import java.util.ArrayList;

import org.hibernate.mapping.List;
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
	
	public void PushRecipeTestData() {
		
		Ingredient ingredient1 = new Ingredient();
		Ingredient ingredient2 = new Ingredient();
		Ingredient ingredient3 = new Ingredient();
		Ingredient ingredient4 = new Ingredient();
		
		ingredient1.setName("Pasta");
		ingredient1 = ir.save(ingredient1);
		
		ingredient2.setName("Pesto");
		ingredient2 = ir.save(ingredient2);
		
		ingredient3.setName("Cracker");
		ingredient3 = ir.save(ingredient3);
		
		ingredient4.setName("Kaas");
		ingredient4 = ir.save(ingredient1);
		
		RecipeIngredient recipeIngredient1 = new RecipeIngredient();
		RecipeIngredient recipeIngredient2 = new RecipeIngredient();
		RecipeIngredient recipeIngredient3 = new RecipeIngredient();
		RecipeIngredient recipeIngredient4 = new RecipeIngredient();
		
		recipeIngredient1.setIngredient(ingredient1);
		recipeIngredient1.setAmountType(QuantityType.GRAM);
		recipeIngredient1.setAmount(240);
		recipeIngredient1 = rir.save(recipeIngredient1);
		
		recipeIngredient2.setIngredient(ingredient1);
		recipeIngredient2.setAmountType(QuantityType.EETLEPEL);
		recipeIngredient2.setAmount(4);
		recipeIngredient2 = rir.save(recipeIngredient1);
		
		recipeIngredient3.setIngredient(ingredient3);
		recipeIngredient3.setAmountType(QuantityType.STUK);
		recipeIngredient3.setAmount(1);
		recipeIngredient3 = rir.save(recipeIngredient3);
		
		recipeIngredient4.setIngredient(ingredient4);
		recipeIngredient4.setAmountType(QuantityType.SNEE);
		recipeIngredient4.setAmount(2);
		recipeIngredient4 = rir.save(recipeIngredient4);
		
		Recept recipe1 = new Recept();
		ArrayList<RecipeIngredient> recipelist1 = new ArrayList<RecipeIngredient>();
		Recept recipe2 = new Recept();
		ArrayList<RecipeIngredient> recipelist2 = new ArrayList<RecipeIngredient>();
		
		recipe1.setName("Pasta pesto");
		recipe1.setInstructions("Kook de pasta volgens de instructies op de verpakking. "
				+ "Voeg de pesto toe aan de pasta en meng deze.");
		recipe1.setCookingTime(20);
		recipe1.setTotalPortions(4);
		recipe1.setvegitarian(true);
		recipelist1.add(recipeIngredient1);
		recipelist1.add(recipeIngredient2);
		recipe1.setIngredients(recipelist1);
		
		recipe2.setName("Cracker met kaas");
		recipe2.setInstructions("Haal de cracker uit de verpakking. "
				+ "Snij twee plakjes kaas en leg deze op de cracker");
		recipe2.setCookingTime(5);
		recipe2.setTotalPortions(1);
		recipe2.setvegitarian(true);
		recipelist2.add(recipeIngredient3);
		recipelist2.add(recipeIngredient4);
		recipe1.setIngredients(recipelist2);
		
		
		
		
	}
	
}
