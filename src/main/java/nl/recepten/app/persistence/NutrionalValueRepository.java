package nl.recepten.app.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import nl.recepten.app.model.NutrionalValue;

@Component
public interface NutrionalValueRepository extends CrudRepository<NutrionalValue, Long>{

}
