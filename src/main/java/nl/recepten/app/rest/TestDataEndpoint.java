package nl.recepten.app.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import nl.recepten.app.model.Recept;
import nl.recepten.app.model.User;
import nl.recepten.app.persistence.TestDataService;

@RestController
public class TestDataEndpoint {

	@Autowired
	TestDataService tds;
	
	@GetMapping("PushTestData")
	public void PushTestData() {
		User user = tds.createRecipeHavingUser();
		User user2 = tds.createStockHavingUser();
		Recept recipe1 = tds.pushPastaPesto(user);
		Recept recipe2 = tds.pushCrackerMetKaas(user);
	}
}