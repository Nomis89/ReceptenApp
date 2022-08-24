package nl.recepten.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class QuantityType {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "QuantityName")
	private String quantityName;

	public String getQuantityName() {
		return quantityName;
	}

	public void setQuantityName(String quantityNameValue) {
		quantityName = quantityNameValue;
	}
	
	
}
