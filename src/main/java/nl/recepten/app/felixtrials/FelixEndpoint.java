package nl.recepten.app.felixtrials;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import nl.recepten.app.model.Recept;
import nl.recepten.app.persistence.ReceptRepository;

@RestController
public class FelixEndpoint {
	@Autowired
	ReceptRepository rr;
	
	@PostMapping("demoolc")
	public void postRecept(@RequestBody Recept recept) {
		System.out.println(recept.getNaam());
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
