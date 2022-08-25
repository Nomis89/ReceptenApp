package nl.recepten.app.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import nl.recepten.app.model.Gebruiker;

@Component
public interface GebruikerRepository extends CrudRepository<Gebruiker, Long>{

}
