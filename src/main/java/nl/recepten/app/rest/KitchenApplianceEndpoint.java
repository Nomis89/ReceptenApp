package nl.recepten.app.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import nl.recepten.app.model.KitchenAppliance;


@RestController
public class KitchenApplianceEndpoint {

	@GetMapping("/returnKitchenAppliance")
	public KitchenAppliance[] returnKitchenAppliances() {
		System.out.println("returnKitchenAppliances");
		return KitchenAppliance.values();
	}

}
