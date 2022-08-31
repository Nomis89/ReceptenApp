package nl.recepten.app.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import nl.recepten.app.persistence.ReceptService;
import nl.recepten.app.persistence.TestDataService;

@RestController
public class TestDataEndpoint {

	@Autowired
	TestDataService tds;
	
	@GetMapping("PushTestData")
	public void PushTestData() {
		tds.pushPastaPesto();
		tds.pushCrackerMetKaas();
	}
}
