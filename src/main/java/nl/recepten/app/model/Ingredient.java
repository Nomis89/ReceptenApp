package nl.recepten.app.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Ingredient {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@OneToMany(fetch = FetchType.LAZY, orphanRemoval = false, mappedBy = "ingredient")
	private List<NutrionalValue> nutrionalValues;
	
	public List<NutrionalValue> getNutrionalValues() {
		return nutrionalValues;
	}

	public void setNutrionalValues(List<NutrionalValue> nutrionalValues) {
		this.nutrionalValues = nutrionalValues;
	}
	
	@OneToMany(fetch = FetchType.LAZY, orphanRemoval = false, mappedBy = "ingredient")
	private List<Stock> stocks;
	
	public List<Stock> getStocks() {
		return stocks;
	}

	public void setStocks(List<Stock> stocks) {
		this.stocks = stocks;
	}

	@Column(name = "ingredient_name")
	private String name;

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
	
	
}
