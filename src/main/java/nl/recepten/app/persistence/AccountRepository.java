package nl.recepten.app.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import nl.recepten.app.model.Account;

@Component
public interface AccountRepository extends CrudRepository<Account, Long> {

}
