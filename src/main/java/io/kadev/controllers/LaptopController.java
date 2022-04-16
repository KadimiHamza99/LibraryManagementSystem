package io.kadev.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.kadev.entities.Laptop;
import io.kadev.services.LibraryServiceImpl;

@RestController
public class LaptopController {
	@Autowired
	private LibraryServiceImpl lsi;
	@GetMapping("/laptops")
	public List<Laptop> getAllLaptops(){
		return lsi.getLaptops();
	}
}
