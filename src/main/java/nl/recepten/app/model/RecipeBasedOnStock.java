package nl.recepten.app.model;

public class RecipeBasedOnStock extends Recept{

	public RecipeBasedOnStock(Recept recept) {
		this.setCookingTime(recept.getCookingTime());
		
	}
	
}
