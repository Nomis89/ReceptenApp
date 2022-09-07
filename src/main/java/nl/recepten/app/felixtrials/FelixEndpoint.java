package nl.recepten.app.felixtrials;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import nl.recepten.app.model.Account;
import nl.recepten.app.model.Recept;
import nl.recepten.app.persistence.AccountRepository;
import nl.recepten.app.persistence.ReceptRepository;

@RestController
public class FelixEndpoint {
	@Autowired
	ReceptRepository rr;
	
	@Autowired
	AccountRepository ar;
	
	
	@GetMapping("zoekenAccount/{voornaam}")
	public long zoekAccount(@PathVariable("voornaam") String denaam) {
		System.out.println(denaam);
		Iterable<Account> accounts = ar.findAll();
		for(Account a : accounts) {
			System.out.println(a.getUserName());
			if(a.getUserName().equals(denaam)) {
				System.out.println("gevonden");
				// HIER ik heb m
				System.out.println("dit is zijn ID"+ a.getId());
				return a.getId();
			}
		}
		return -1;
	}
	
	@PostMapping("demoolc")
	public void postRecept(@RequestBody Recept recept) {
		System.out.println(recept.getName());
	}
	
	@GetMapping("felix1")
	public Iterable<Recept> alleRecepten(){
		return rr.findAll();
	}
	
	@GetMapping("felix2/{mijnkeuze}")
	public void felix2methode(@PathVariable("mijnkeuze") String param) {
		System.out.println("Dit is meegegeven: "+ param);
	}
	
	@PostMapping("felix3")
	public void felix3methoden(@RequestBody Recept recept) {
		System.out.println(recept.getName());
	}
}
