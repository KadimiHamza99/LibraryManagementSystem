package io.kadev.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.kadev.entities.Laptop;
import io.kadev.entities.enums.StateEnum;
import io.kadev.services.LibraryServiceImpl;

@RestController
@RequestMapping("/laptops")
public class LaptopController {
	
	@Autowired
	private LibraryServiceImpl lsi;
	
	@PostMapping("/add")
	public void addLaptop(@RequestBody Laptop laptop) {
		lsi.addLaptop(laptop);
	}
	
	@DeleteMapping("/delete/{idLap}")
	public void removeLaptop(@PathVariable Long idLap) {
		lsi.removeLaptop(idLap);
	}
	
	@PutMapping("/update/{idLap}")
	public void updateLaptop(@PathVariable Long idLap
							,@RequestParam(required = false) boolean changed
							,@RequestParam(required = false) String state) {
		if(changed) lsi.changeLapFunct(idLap);
		StateEnum[] states = StateEnum.values();
		for (StateEnum s : states) {
			if(s.toString().equals(state)) lsi.changeLapState(idLap, s);
		}
	}
	
	@GetMapping("/get/available")
	public List<Laptop> getAvailableLaptops(){
		return lsi.getAvailableLaps();
	}
	
	@GetMapping("/get/{id}")
	public Laptop getLaptop(@PathVariable Long id) {
		return lsi.getLaptop(id);
	}
	
	@GetMapping("/get")
	public List<Laptop> getAllLaptops(){
		return lsi.getLaptops();
	}
	
	
}
