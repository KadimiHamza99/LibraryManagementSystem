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

import io.kadev.entities.Document;
import io.kadev.entities.enums.StateEnum;
import io.kadev.services.LibraryServiceImpl;

@RestController
@RequestMapping("/documents")
public class DocumentController {
	@Autowired
	private LibraryServiceImpl lsi; 
	
	@PostMapping("/add")
	public void addDocument(@RequestBody Document doc) {
		lsi.addDocument(doc);
	}
	
	@DeleteMapping("/delete/{id}")
	public void removeDocument(@PathVariable Long id) {
		lsi.removeDocument(id);
	}
	
	@GetMapping("/get/available")
	public List<Document> getAvailableDocuments(){
		return lsi.getAvailableDocs();
	}
	
	@GetMapping("/get")
	public List<Document> getAllDocuments(){
		return lsi.getDocuments();
	}
	
	@GetMapping("/get/{id}")
	public Document getDocument(@PathVariable Long id) {
		return lsi.getDocument(id);
	}
	
	@PutMapping("/update/{id}")
	public void updateDocument(@PathVariable Long id,@RequestParam(required = false) String state) {
		StateEnum[] states = StateEnum.values();
		for (StateEnum s : states) {
			if(s.toString().equals(state)) lsi.changeDocState(id, s);
		}
	}
}
