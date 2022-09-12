package nl.recepten.app.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import at.favre.lib.crypto.bcrypt.BCrypt;
import nl.recepten.app.model.Account;

@Service
public class AccountService {
	@Autowired
	AccountRepository acc;
	
	// Check if it is allowed to create a new account
	public boolean checkSignUp(Account account) {
		String userName = account.getUserName();
		String eMail = account.getEmail();	
		
		Account accountCandidate = acc.checkAccountInDB(userName, eMail);
		
		// If credentials are already use
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
	
	// Delete the account
	public void delAccount(Account account) {
		acc.delete(account);
	}
	
	
	// Remember the logged in account during session through account ID
	public Account accountSession(long id) {
		Account currentAccount = acc.getLoggedInAccount(id);
		
		return currentAccount;
	}
	
	// Log in the requested account
	public Account logInAccount(Account account) {
		// The account to log in to
		String userName = account.getUserName();
		String passWord = account.getPassWord();
		
		Account loggedInAccount = acc.getAccount(userName);
		
		if(loggedInAccount != null) {
			BCrypt.Result result = BCrypt.verifyer().verify(passWord.toCharArray(), loggedInAccount.getPassWord());
			// Wrong password, don't allow log in
			if(result.verified==false) {
				loggedInAccount = null;
			}
		}
		
		// Returns the requested account or null if either not found in the database or wrong password
		return loggedInAccount;
	}
}
