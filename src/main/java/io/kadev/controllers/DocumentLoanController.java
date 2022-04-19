package io.kadev.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.kadev.entities.LoanDocument;
import io.kadev.services.LibraryServiceImpl;

@RestController
@RequestMapping("/documents_loans")
public class DocumentLoanController {
	@Autowired
	private LibraryServiceImpl lsi;
	@GetMapping("/get")
	public List<LoanDocument> getDocumentsLoans(){
		return lsi.getAllDocumentLoans();
	}
}
