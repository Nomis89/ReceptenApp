package nl.recepten.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class RecipeIngredient {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@ManyToOne(optional = false)
	private Recept recipe;
	
	@ManyToOne
	private Ingredient ingredient;
	
	private double amount;
	private QuantityType amountType;
	
	@JsonIgnore
	public Recept getRecipe() {
		return recipe;
	}
	public void setRecipe(Recept recipe) {
		this.recipe = recipe;
	}
	// COMMENT: Staan uit omdat ze ingredient gebruiken.
	// Nieuwe getters en setters moeten gemaakt worden als de long als oplossing blijft bestaan.
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
