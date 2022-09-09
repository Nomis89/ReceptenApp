package nl.recepten.app.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import nl.recepten.app.model.Account;
import nl.recepten.app.model.Stock;
import nl.recepten.app.persistence.AccountService;
import nl.recepten.app.persistence.StockRepository;
import nl.recepten.app.persistence.StockService;

@RestController
public class StockEndpoint {
	
	@Autowired
	StockService stockservice; 
	
	@Autowired
	StockRepository stockrepository;
	
	@Autowired
	AccountService as;
	
	@GetMapping("/allstock")
	public Iterable<Stock> allStock(){
		return stockservice.allStock();

	}
	
	@PostMapping("/stock")
	public void addStock(@RequestBody Stock stock) {
		stockservice.saveStock(stock);

	}
	
	@GetMapping("/stockFromAccount/{id}")
	public Iterable<Stock> stockFromAccount (@PathVariable("id") long id){
		
		Account account = as.accountSession(id);
		System.out.println(account.getEmail());
		System.out.println(account.getUser().getName());
		Iterable<Stock> stockItems =  stockrepository.findByuser(account.getUser());
		System.out.println("werkt");
		for (Stock s : stockItems) {
			System.out.println(s.getIngredient().getName());
		}
		return stockItems;
	}
}
