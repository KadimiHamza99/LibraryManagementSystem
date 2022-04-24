package io.kadev.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.kadev.entities.LoanDocument;
import io.kadev.services.LibraryServiceImpl;

@RestController
@RequestMapping("/documents_loans")
public class DocumentLoanController {
	@Autowired
	private LibraryServiceImpl lsi;
	
	@PostMapping("/loan/doc")
	public void loanDocument(@RequestParam(name = "idAdh") Long idAdh
							,@RequestParam(name = "idDoc") Long idDoc) {
		lsi.loanDocument(idAdh, idDoc);
	}
	
	@PostMapping("/loan/docs")
	public void loanDocuments(@RequestParam Long idAdh
							,@RequestParam(value = "id") List<Long> idDocs) {
		lsi.loanDocuments(idAdh, idDocs);
	}
	
	@PostMapping("/return/doc")
	public void returnDocument(@RequestParam(name = "idAdh") Long idAdh
							  ,@RequestParam(name = "idDoc") Long idDoc) {
		lsi.returnDocument(idAdh, idDoc);
	}
	
	@GetMapping("/get")
	public List<LoanDocument> getDocumentsLoans(){
		return lsi.getAllDocumentLoans();
	}
}
