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

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	@Column(name = "image", unique = false, nullable = false, length = 100000)
	private String image;
	private KitchenAppliance benodigdHeden;
	
	public KitchenAppliance getBenodigdHeden() {
		return benodigdHeden;
	}
	public void setBenodigdHeden(KitchenAppliance benodigdHeden) {
		this.benodigdHeden = benodigdHeden;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	@ManyToOne(optional = true)
	private User user;
	
	@JsonIgnore
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@ElementCollection(targetClass = KitchenAppliance.class)
	@JoinTable(name = "recipeKitchenAppliance", joinColumns = @JoinColumn(name = "id"))
	@Column(name = "KitchenAppliance", nullable = true)
	@Enumerated(EnumType.STRING)
	private List<KitchenAppliance> kitchenAppliance;

	public List<KitchenAppliance> getKitchenAppliance() {
		return kitchenAppliance;
	}
	public void setKitchenAppliance(List<KitchenAppliance> kitchenAppliance) {
		this.kitchenAppliance = kitchenAppliance;
	}
	private boolean vegitarian;
	
	@OneToMany(orphanRemoval = true, fetch = FetchType.LAZY, mappedBy = "recept")
	@JsonIgnore
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
