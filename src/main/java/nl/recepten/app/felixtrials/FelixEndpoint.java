package nl.recepten.app.felixtrials;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.internal.build.AllowSysOut;
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
				System.out.println("de userId"+a.getUser().getId());
				return a.getUser().getId();
			}
		}
		return -1;
	}
	@GetMapping("vindReceptenVanAccount/{userId}")
	public List<Recept> vindAlleRecepten(@PathVariable("userId") int uid) {
		System.out.println(uid);
		Iterable<Recept> recepten = rr.findAll();
		List<Recept> rec = new ArrayList();
		for(Recept r : recepten) {
			System.out.println(r);
			// OF je gebruikt de drie versnellingen van de CRUD
			// versnelling
			if(r.getUser() == null) {
				
			}else{
				System.out.println(  r.getUser().getId());
				if(r.getUser().getId() == uid ) {
					rec.add(r);
				}
			}
		}
		return rec;
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
