package io.kadev.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.kadev.entities.Adherent;
import io.kadev.services.LibraryServiceImpl;

@RestController
@RequestMapping("/adherents")
public class AdherentController {
	@Autowired
	private LibraryServiceImpl lsi;
	
	@GetMapping("/get")
	public List<Adherent> getAllAdherents(){
		return lsi.getAdherents();
	}
}
