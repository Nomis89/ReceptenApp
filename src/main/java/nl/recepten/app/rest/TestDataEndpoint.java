package nl.recepten.app.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import nl.recepten.app.persistence.ReceptService;

@RestController
public class TestDataEndpoint {

	@Autowired
	ReceptService rs;
	
	@GetMapping("PushTestData")
	public void PushTestData() {
		rs.PushRecipeTestData();
	}
}
