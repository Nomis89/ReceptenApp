package nl.recepten.app.persistence;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import nl.recepten.app.model.Account;

@Component
public interface AccountRepository extends CrudRepository<Account, Long> {
	@Query(value = "SELECT * FROM receptenapp.account WHERE user_name = ?1 AND pass_word = ?2", nativeQuery=true)
	Account getAccount(String accountName, String passWord);
	
	@Query(value = "SELECT * FROM receptenapp.account WHERE id = ?1", nativeQuery=true)
	Account getLoggedInAccount(long id);
	
	@Query(value = "SELECT * FROM receptenapp.account WHERE user_name = ?1 OR email = ?2", nativeQuery=true)
	Account checkAccountInDB(String accountName, String email);
	
}