package nl.recepten.app.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import nl.recepten.app.persistence.GebruikerService;

@RestController
public class GebruikerEndpoint {
		
	@Autowired
		GebruikerService gs;
	
	@GetMapping("/test1")
	public String letsgo() {
		System.out.println("it works");
		return "Volgens mij doet hij het";
		
	}
	
}
