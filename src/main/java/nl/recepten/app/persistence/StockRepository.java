package nl.recepten.app.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import nl.recepten.app.model.Stock;

@Component
public interface StockRepository extends CrudRepository<Stock, Long> {

}	
