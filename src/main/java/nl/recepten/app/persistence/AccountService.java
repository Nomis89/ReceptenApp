package nl.recepten.app.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nl.recepten.app.model.Account;

@Service
public class AccountService {
	@Autowired
	AccountRepository acc;
	
	// Check if it is allowed to create a new account
	public boolean checkSignUp(Account account) {
		// If credentials are already use
		String userName = account.getUserName();
		String eMail = account.getEmail();	
		
		Account accountCandidate = acc.checkAccountInDB(userName, eMail);
		
		if(accountCandidate == null) {
			System.out.println("Account is not taken!");
			return true;
		} else {
			System.out.println("Account is taken!");
			return false;
		}
	}
	
	// Create the account through JSON format
	public void createAccount(Account account) {
		acc.save(account);
	}
	
	// Remember the logged in account during session through account ID
	public Account accountSession(long id) {
		Account currentAccount = acc.getLoggedInAccount(id);
		
		return currentAccount;
	}
	
	// Log in the requested account
	public Account logInAccount(Account account) {
		String userName = account.getUserName();
		String passWord = account.getPassWord();		
		Account loggedInAccount = acc.getAccount(userName, passWord);
		
		return loggedInAccount;
	}
}
