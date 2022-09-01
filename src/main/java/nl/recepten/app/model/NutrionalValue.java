package nl.recepten.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class NutrionalValue {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@ManyToOne
	private Ingredient ingredient;
	private int calories;
	private double fat;
	private double carbs;
	private double protien;
	private double fiber;

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getCalories() {
		return calories;
	}
	public void setCalories(int calories) {
		this.calories = calories;
	}
	public double getFat() {
		return fat;
	}
	public void setFat(double fat) {
		this.fat = fat;
	}
	public double getCarbs() {
		return carbs;
	}
	public void setCarbs(double carbs) {
		this.carbs = carbs;
	}
	public double getProtien() {
		return protien;
	}
	public void setProtien(double protien) {
		this.protien = protien;
	}
	public double getFiber() {
		return fiber;
	}
	public void setFiber(double fiber) {
		this.fiber = fiber;
	}
}
