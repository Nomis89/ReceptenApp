package nl.recepten.app.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nl.recepten.app.model.QuantityType;

@Service
public class QuantityTypeService {

	@Autowired
	QuantityTypeRepository qtr;
	
	public void saveEmptyQTR () {
		System.out.println("saveEmptyQTR werkt.");
		qtr.save(new QuantityType());
	}
	
	public void saveQTR (String value) {
		QuantityType quantityType = new QuantityType();
		quantityType.setQuantityName(value);
		qtr.save(quantityType);
	}
}
