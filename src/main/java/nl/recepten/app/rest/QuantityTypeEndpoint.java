package nl.recepten.app.rest;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import nl.recepten.app.model.QuantityType;



@RestController
public class QuantityTypeEndpoint {

	@GetMapping("/returnQuantityTypes")
	public QuantityType[] returnQuantityTypes() {
		System.out.println("returnQuantityTypes");
		return QuantityType.values();
	}
	
}
