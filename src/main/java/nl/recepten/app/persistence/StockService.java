package nl.recepten.app.persistence;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nl.recepten.app.model.Stock;

@Service
public class StockService {
	@Autowired
	StockRepository stockrepository;
	
	public void saveStock(Stock stock) {
		stockrepository.save(stock);
	}
	
	public Iterable<Stock> allStock(){
		return stockrepository.findAll();
	}
	
	


}
