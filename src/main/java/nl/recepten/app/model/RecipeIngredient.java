package nl.recepten.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class RecipeIngredient {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@ManyToOne(optional = false)
	private Recept recipe;
	
	@ManyToOne(optional = false)
	private Ingredient ingredient;
	
	private double amount;
	private QuantityType amountType;
	
	public Recept getRecipe() {
		return recipe;
	}
	public void setRecipe(Recept recipe) {
		this.recipe = recipe;
	}
	public Ingredient getIngredient() {
		return ingredient;
	}
	public void setIngredient(Ingredient ingredient) {
		this.ingredient = ingredient;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public QuantityType getAmountType() {
		return amountType;
	}
	public void setAmountType(QuantityType amountType) {
		this.amountType = amountType;
	}
	
}
