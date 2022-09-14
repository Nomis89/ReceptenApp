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
import nl.recepten.app.persistence.IngredientService;
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
	
	@Autowired
	IngredientService is;
	
	@GetMapping("/allstock")
	public Iterable<Stock> allStock(){
		return stockservice.allStock();
	}
	
	@PostMapping("/stock")
	public void addStock(@RequestBody Stock stock) {
		stockservice.saveStock(stock);
	}
	
	@GetMapping("/deleteStock/{id}")
	public void deleteStock (@PathVariable("id") long id) {
		System.out.println("Stock with the following id will be deleted: " + id);
		stockrepository.deleteById(id);
	}
	
	@PostMapping("/addStock/{id}/{ingredientName}")
	public void addStockWithAccountID(@RequestBody Stock stock, @PathVariable("id") long id, @PathVariable("ingredientName") String ingredientName) {
		System.out.println("Ingredient name is: " + ingredientName);
		
		Account account = as.accountSession(id);
		stock.setUser(account.getUser());
		stock.setIngredient(is.checkExistenceOrCreate(ingredientName));
		stockservice.saveStock(stock);
	}
	
	@GetMapping("/stockFromAccount/{id}")
	public Iterable<Stock> stockFromAccount (@PathVariable("id") long id){
		Account account = as.accountSession(id);
		Iterable<Stock> stockItems =  stockrepository.findByuser(account.getUser());
		for (Stock s : stockItems) {
			System.out.println(s.getIngredient().getName());
		}
		return stockItems;
	}
	
	@GetMapping("/stockFromID/{id}")
	public Stock getStockbyID(@PathVariable("id") long id) {
		return stockrepository.findById(id).get();
	}
}
