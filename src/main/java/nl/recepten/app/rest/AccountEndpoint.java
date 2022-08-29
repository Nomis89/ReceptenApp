package nl.recepten.app.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import nl.recepten.app.model.Account;
import nl.recepten.app.persistence.AccountService;

@RestController
public class AccountEndpoint {

	@Autowired
	AccountService as;
	
	// Creates an account using JSON format. Account details will be saved in an account database.
	@PostMapping("/signup")
	public void signUp(@RequestBody Account account) {
		as.createAccount(account);
	}
	
	
}

