package io.kadev.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.kadev.entities.Adherent;
import io.kadev.services.LibraryServiceImpl;

@RestController
public class AdherentController {
	@Autowired
	private LibraryServiceImpl lsi;
	
	@GetMapping("/adherents")
	public List<Adherent> getAllAdherents(){
		return lsi.getAdherents();
	}
}
