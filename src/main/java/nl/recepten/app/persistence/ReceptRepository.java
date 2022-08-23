package nl.recepten.app.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import nl.recepten.app.model.Recept;

@Component
public interface ReceptRepository extends CrudRepository<Recept, Long>{ 
	
}
