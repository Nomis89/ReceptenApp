package nl.recepten.app.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
	
	@ManyToOne(optional = true)
	private User user;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
//	@ElementCollection(targetClass = KitchenAppliance.class)
//	@JoinTable(name = "recipeKitchenAppliance", joinColumns = @JoinColumn(name = "id"))
//	@Column(name = "KitchenAppliance", nullable = true)
//	@Enumerated(EnumType.STRING)
//	private List<KitchenAppliance> kitchenAppliance;

//	public List<KitchenAppliance> getKitchenAppliance() {
//		return kitchenAppliance;
//	}
//	public void setKitchenAppliance(List<KitchenAppliance> kitchenAppliance) {
//		this.kitchenAppliance = kitchenAppliance;
//	}
	private boolean vegitarian;
	
	@OneToMany(orphanRemoval = true, fetch = FetchType.LAZY, mappedBy = "recipe")
	private List<RecipeIngredient> ingredients;

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public List<RecipeIngredient> getIngredients() {
		return ingredients;
	}
	public void setIngredients(List<RecipeIngredient> ingredients) {
		this.ingredients = ingredients;
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
