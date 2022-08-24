package nl.recepten.app.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import nl.recepten.app.persistence.QuantityTypeService;

@RestController
public class QuantityTypeEndpoint {

	@Autowired
	QuantityTypeService qts;
	
	@GetMapping("/qtsTest/{mijnInput}")
	public String saveqts(@PathVariable("mijnInput") String value) {
		System.out.println("saveqts");
		qts.saveQTR(value);
		return "qts opslaan succesvol";
	}
	
}
