package nl.recepten.app.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import nl.recepten.app.model.Recept;
import nl.recepten.app.persistence.ReceptService;

@RestController
public class ReceptEndpoint {
	
	@Autowired
	ReceptService rs;
	
	@GetMapping("Simon")
	public String endpoint () {
		System.out.println("we zijn in het endpoint");
		rs.receptService();
		return "Hoi dit is zichtbaar ergens";
	}
	
	@GetMapping("Felix")
	public Recept endpoint2 () {
		System.out.println("we zijn in het endpoint");
		return new Recept();
	}
}
