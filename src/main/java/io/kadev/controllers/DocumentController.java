package io.kadev.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.kadev.entities.Document;
import io.kadev.services.LibraryServiceImpl;

@RestController
public class DocumentController {
	@Autowired
	private LibraryServiceImpl lsi; 
	@GetMapping("/documents")
	public List<Document> getAllDocuments(){
		return lsi.getDocuments();
	}
}
