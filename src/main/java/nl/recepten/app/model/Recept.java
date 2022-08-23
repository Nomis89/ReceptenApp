package nl.recepten.app.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Entity;

@Entity
public class Recept {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "receptnaam")
	private String naam;
	private String omschrijving;
	private String ingredienten;	
	private int voorbereidingsTijd;
	private int bereidingsTijd;
	private LocalDateTime aanmaakDatum;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNaam() {
		return naam;
	}
	public void setNaam(String naam) {
		this.naam = naam;
	}
	public String getOmschrijving() {
		return omschrijving;
	}
	public void setOmschrijving(String omschrijving) {
		this.omschrijving = omschrijving;
	}
	public String getIngredienten() {
		return ingredienten;
	}
	public void setIngredienten(String ingredienten) {
		this.ingredienten = ingredienten;
	}
	public int getVoorbereidingsTijd() {
		return voorbereidingsTijd;
	}
	public void setVoorbereidingsTijd(int voorbereidingsTijd) {
		this.voorbereidingsTijd = voorbereidingsTijd;
	}
	public int getBereidingsTijd() {
		return bereidingsTijd;
	}
	public void setBereidingsTijd(int bereidingsTijd) {
		this.bereidingsTijd = bereidingsTijd;
	}
	public LocalDateTime getAanmaakTijdstip() {
		return aanmaakDatum;
	}
	public void setAanmaakTijdstip(LocalDateTime aanmaakTijdstip) {
		this.aanmaakDatum = aanmaakTijdstip;
	}
	
	
	
}
