package nl.recepten.app.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import at.favre.lib.crypto.bcrypt.BCrypt;
import nl.recepten.app.model.Account;
import nl.recepten.app.model.User;
import nl.recepten.app.persistence.AccountService;
import nl.recepten.app.persistence.UserService;

@RestController
public class AccountEndpoint {

	@Autowired
	AccountService as;
	
	@Autowired
	UserService us;
	
	// Creates an account using JSON format. Account details will be saved in an account database.
	@PostMapping("/signup")
	public long signUp(@RequestBody Account account) {
		System.out.println("Creating account...");
		
		// Can't create account, return -1
		if(as.checkSignUp(account)==false) {
			return -1;
		} else {
			// Create empty user profile for the newly created account
			User emptyUser = new User();
			// Let all fields be empty strings
			emptyUser.setName("");
			emptyUser.setDescription("");
			emptyUser.setCityName("");
			emptyUser.setStreetName("");
			emptyUser.setHouseNumberAddition("");
			emptyUser.setZipCode("");
			us.saveUser(emptyUser);
			
			// Set OneToOne with user profile
			account.setUser(emptyUser);
			
			// Create the new account
			String password = account.getPassWord();
			String pwHash = BCrypt.withDefaults().hashToString(12, password.toCharArray());
			account.setPassWord(pwHash);
			
			as.createAccount(account);
			
			System.out.println(account.getId());
			
			System.out.println("Account created!");
			
			System.out.println("");
			System.out.println("Sending account ID to frontend...");
			return account.getId();
		}
	}
	
	@PostMapping("/login")
	public long login(@RequestBody Account account) {
		System.out.println("Logging in...");
		
		Account loggedInAccount = as.logInAccount(account);
		
		if (loggedInAccount == null) {
			System.out.println("Wrong credentials or account does not exist!");
			return -1;
		} else {
			System.out.println("Logged in!");
			return loggedInAccount.getId();
		}
	}
	
	@PostMapping("/profile")
	public Account profile(@RequestBody Account account) {
		System.out.println("Getting profile data...");
		
		Account loggedInAccount = as.accountSession(account.getId());
		
		return loggedInAccount;
	}
	
	@DeleteMapping("/deleteAccount/{id}")
	public void deleteAccount(@PathVariable("id")long accountId) {
		Account loggedInAccount = as.accountSession(accountId);
		as.delAccount(loggedInAccount);
	}
	
}

