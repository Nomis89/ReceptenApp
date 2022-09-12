package nl.recepten.app.persistence;

import java.sql.Date;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nl.recepten.app.model.Account;
import nl.recepten.app.model.Ingredient;
import nl.recepten.app.model.KitchenAppliance;
import nl.recepten.app.model.QuantityType;
import nl.recepten.app.model.Recept;
import nl.recepten.app.model.RecipeIngredient;
import nl.recepten.app.model.Stock;
import nl.recepten.app.model.User;


@Service
public class TestDataService {

	@Autowired
	ReceptRepository rr;
	
	@Autowired
	IngredientRepository ir;
	
	@Autowired
	RecipeIngredientRepository rir;
	
	@Autowired
	UserRepository ur;
	
	@Autowired
	AccountRepository ar;
	
	@Autowired
	StockRepository sr;
	
	@Autowired
	IngredientService is;
	
	public Recept pushPastaPesto(User user) {
		Ingredient ingredient1 = new Ingredient();
		Ingredient ingredient2 = new Ingredient();
		
		RecipeIngredient recipeIngredient1 = new RecipeIngredient();
		RecipeIngredient recipeIngredient2 = new RecipeIngredient();
		
		
		Recept recipe = new Recept();
		ArrayList<RecipeIngredient> recipelist = new ArrayList<RecipeIngredient>();
		ArrayList<KitchenAppliance> kitchenappliances= new ArrayList<KitchenAppliance>();
		
		ingredient1 = is.checkExistenceOrCreate("Pasta");
		
		ingredient2 = is.checkExistenceOrCreate("Pesto");
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
//		recipe.setKitchenAppliance(kitchenappliances);
		recipe.setUser(user);
		
		recipe = rr.save(recipe);
		
		recipeIngredient1 = rir.save(recipeIngredient1);
		recipeIngredient2 = rir.save(recipeIngredient2);
//		System.out.println("recept gemaakt");
		return recipe;
	}
	
	public Recept pushPastaPestoKaas(User user) {
		Ingredient ingredient1 = new Ingredient();
		Ingredient ingredient2 = new Ingredient();
		Ingredient ingredient3 = new Ingredient();
		
		RecipeIngredient recipeIngredient1 = new RecipeIngredient();
		RecipeIngredient recipeIngredient2 = new RecipeIngredient();
		RecipeIngredient recipeIngredient3 = new RecipeIngredient();
		
		
		Recept recipe = new Recept();
		ArrayList<RecipeIngredient> recipelist = new ArrayList<RecipeIngredient>();
		ArrayList<KitchenAppliance> kitchenappliances= new ArrayList<KitchenAppliance>();
		
		ingredient1 = is.checkExistenceOrCreate("Pasta");
		
		ingredient2 = is.checkExistenceOrCreate("Pesto");
		
		ingredient3 = is.checkExistenceOrCreate("kaas");
//		System.out.println("ingredienten gemaakt");
		
		recipeIngredient1.setIngredient(ingredient1);
		recipeIngredient1.setAmountType(QuantityType.GRAM);
		recipeIngredient1.setAmount(240);
		recipeIngredient1.setRecipe(recipe);

		recipeIngredient2.setIngredient(ingredient2);
		recipeIngredient2.setAmountType(QuantityType.EETLEPEL);
		recipeIngredient2.setAmount(4);
		recipeIngredient2.setRecipe(recipe);
		
		recipeIngredient3.setIngredient(ingredient3);
		recipeIngredient3.setAmountType(QuantityType.GRAM);
		recipeIngredient3.setAmount(200);
		recipeIngredient3.setRecipe(recipe);
		
//		System.out.println("Alle recipeIngredients gemaakt");
		
		recipelist.add(recipeIngredient1);
		recipelist.add(recipeIngredient2);
		recipelist.add(recipeIngredient3);
		
		kitchenappliances.add(KitchenAppliance.BLENDER);
		kitchenappliances.add(KitchenAppliance.VIJZEL);
		
		recipe.setName("Pasta pesto met kaas");
		recipe.setInstructions("Kook de pasta volgens de instructies op de verpakking. "
				+ "Voeg de pesto toe aan de pasta en meng deze."
				+ "Voeg hierna ook de kaas toe");
		recipe.setCookingTime(20);
		recipe.setTotalPortions(4);
		recipe.setvegitarian(true);
		recipe.setIngredients(recipelist);
//		recipe.setKitchenAppliance(kitchenappliances);
		recipe.setUser(user);
		
		recipe = rr.save(recipe);
		
		recipeIngredient1 = rir.save(recipeIngredient1);
		recipeIngredient2 = rir.save(recipeIngredient2);
		recipeIngredient3 = rir.save(recipeIngredient3);
//		System.out.println("recept gemaakt");
		return recipe;
	}
	
	public Recept pushCrackerMetKaas(User user) {
		
		Ingredient ingredient1 = new Ingredient();
		Ingredient ingredient2 = new Ingredient();

		RecipeIngredient recipeIngredient1 = new RecipeIngredient();
		RecipeIngredient recipeIngredient2 = new RecipeIngredient();

		Recept recipe = new Recept();
		ArrayList<RecipeIngredient> recipelist = new ArrayList<RecipeIngredient>();
		
		ingredient1 = is.checkExistenceOrCreate("Kracker");
		
		ingredient2 = is.checkExistenceOrCreate("Kaas");
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
		recipe.setUser(user);
		
		recipe = rr.save(recipe);
		
		recipeIngredient1 = rir.save(recipeIngredient1);
		recipeIngredient2 = rir.save(recipeIngredient2);
//		System.out.println("recept gemaakt");
		return recipe;
	}
	
	public User createRecipeHavingUser() {
		User user = new User();
		Account account = new Account();
		Stock stock = new Stock();
		Ingredient ingredient = new Ingredient();
		
		user.setName("Jan Jansma");
		user.setDescription("Ik ben een legit persoon.");
		user.setCityName("Verwegistan");
		user.setStreetName("Hoofdstraat");
		user.setHouseNumber(1);
		user.setHouseNumberAddition("a");
		user.setZipCode("1111AA");
		
		account.setUser(user);
		account.setPassWord("wachtwoord123");
		account.setUserName("Jan123");
		account.setEmail("jan@jansen.nl");
		
		ingredient = is.checkExistenceOrCreate("Kracker");
		
		stock.setAmount(2);
		stock.setAmountType(QuantityType.STUK);
		stock.setAvailableToOthers(true);
		stock.setExpirationDate(new Date(56446556));
		stock.setUser(user);
		stock.setIngredient(ingredient);
		
//		System.out.println("test1");
		
		ur.save(user);
		ar.save(account);
		sr.save(stock);
		return user;
	}
	
	public User createStockHavingUser() {
		User user = new User();
		Account account = new Account();
		Stock stock = new Stock();
		Ingredient ingredient = new Ingredient();
		
		user.setName("Sjon het Schaap");
		user.setDescription("Ik ben een legit schaap.");
		user.setCityName("Verweghiervan");
		user.setStreetName("Hoofdstraat");
		user.setHouseNumber(2);
		user.setHouseNumberAddition("b");
		user.setZipCode("2222BB");
		
		account.setUser(user);
		account.setPassWord("wachtwoord123");
		account.setUserName("Sjon123");
		account.setEmail("Sjon@schaap.nl");
		
		ingredient = is.checkExistenceOrCreate("Kaas");
		
		stock.setAmount(2);
		stock.setAmountType(QuantityType.SNEE);
		stock.setAvailableToOthers(false);
		stock.setExpirationDate(new Date(56446556));
		stock.setUser(user);
		stock.setIngredient(ingredient);
		
		System.out.println("test1");
		
		ur.save(user);
		ar.save(account);
		sr.save(stock);
		return user;
	}
}
