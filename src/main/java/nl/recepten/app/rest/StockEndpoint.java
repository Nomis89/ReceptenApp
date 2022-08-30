package nl.recepten.app.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import nl.recepten.app.model.Stock;
import nl.recepten.app.persistence.StockService;

@RestController
public class StockEndpoint {
	
	@Autowired
	StockService stockservice; 
	
	@GetMapping("/allstock")
	public Iterable<Stock> allStock(){
		return stockservice.allStock();

	}
	
	@PostMapping("/stock")
	public void addStock(@RequestBody Stock stock) {
		stockservice.saveStock(stock);

}
}
