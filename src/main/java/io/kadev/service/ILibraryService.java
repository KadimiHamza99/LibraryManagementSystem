package io.kadev.service;

import java.util.List;

import io.kadev.entities.Adherent;
import io.kadev.entities.Document;
import io.kadev.entities.Laptop;
import io.kadev.entities.LoanDocument;
import io.kadev.entities.LoanLaptop;

public interface ILibraryService {
	void addAdherent(Adherent a);
	void removeAdherent(Adherent a);
	void addLaptop(Laptop l);
	void removeLaptop(Laptop l);
	void addDocument(Document d);
	void removeDocument(Document d);
	void loanLaptop(Adherent a,Laptop l);
	void returnLaptop(Adherent a,Laptop l);
	List<LoanLaptop> getAllLaptopLoans();
	void loanDocuments(Adherent adherent, List<Document> documents);
	void loanDocument(Adherent adherent, Document document);
	void returnDocuments(Adherent adherent, List<Document> documents);
	void returnDocument(Adherent adherent, Document document);
	List<LoanDocument> getAllDocumentLoans();
}
