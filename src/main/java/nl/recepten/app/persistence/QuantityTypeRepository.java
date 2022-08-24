package nl.recepten.app.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import nl.recepten.app.model.QuantityType;

@Component
public interface QuantityTypeRepository extends CrudRepository<QuantityType, Long>{

}
