package nl.recepten.app.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nl.recepten.app.model.Account;

@Service
public class AccountService {
	@Autowired
	AccountRepository acc;

	public void createAccount(Account account) {
		acc.save(account);
	}
}
