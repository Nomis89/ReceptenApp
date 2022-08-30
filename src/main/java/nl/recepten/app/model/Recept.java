package nl.recepten.app.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Entity;
import javax.persistence.FetchType;

@Entity
public class Recept {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "recipename")
	private String name;
	private String instructions;
	private int cookingTime;
	private int totalPortions;
	private KitchenAppliance kitchenAppliance;

	public KitchenAppliance getKitchenAppliance() {
		return kitchenAppliance;
	}
	public void setKitchenAppliance(KitchenAppliance kitchenAppliance) {
		this.kitchenAppliance = kitchenAppliance;
	}
	private boolean vegitarian;
	
	@OneToMany(orphanRemoval = true, fetch = FetchType.LAZY, mappedBy = "recipe")
	private List<RecipeIngredient> ingredients;

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getInstructions() {
		return instructions;
	}
	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}
	public int getCookingTime() {
		return cookingTime;
	}
	public void setCookingTime(int cookingTime) {
		this.cookingTime = cookingTime;
	}
	public int getTotalPortions() {
		return totalPortions;
	}
	public void setTotalPortions(int totalPortions) {
		this.totalPortions = totalPortions;
	}
	public boolean isvegitarian() {
		return vegitarian;
	}
	public void setvegitarian(boolean vegitarian) {
		this.vegitarian = vegitarian;
	}
}
