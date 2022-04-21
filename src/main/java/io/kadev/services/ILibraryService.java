package io.kadev.services;

import java.time.LocalDate;
import java.util.List;

import io.kadev.entities.Adherent;
import io.kadev.entities.ArchiveDocumentResponse;
import io.kadev.entities.ArchiveLaptopResponse;
import io.kadev.entities.Document;
import io.kadev.entities.Laptop;
import io.kadev.entities.LoanDocument;
import io.kadev.entities.LoanLaptop;
import io.kadev.entities.enums.BrandEnum;
import io.kadev.entities.enums.StateEnum;
import io.kadev.entities.enums.SubscriptionTypeEnum;

public interface ILibraryService {
	//adherent
	void addAdherent(Adherent a);
	void removeAdherent(Adherent a);
	void removeAdherent(Long adhId);
	Adherent getAdherent(Long adhId);
	void extendMembershipAdherent(Long idAdherent,LocalDate expirationMembership,SubscriptionTypeEnum ste);
	List<Adherent> getAdherents();
	List<Adherent> searchAdherents(String search);
	//laptop
	void addLaptop(Laptop l);
	void removeLaptop(Laptop l);
	List<Laptop> getLaptops();
	//document
	void addDocument(Document d);
	void removeDocument(Document d);
	List<Document> getDocuments();
	//loan laptop
	void loanLaptop(Adherent a,Laptop l);
	void returnLaptop(Adherent a,Laptop l,StateEnum s);
	List<LoanLaptop> getAllLaptopLoans();
	void laptopBrokeDown(Laptop laptop);
	//loan document
	void loanDocuments(Adherent adherent, List<Document> documents);
	void loanDocument(Adherent adherent, Document document);
	void returnDocuments(Adherent adherent, List<Document> documents);
	void returnDocument(Adherent adherent, Document document);
	List<LoanDocument> getAllDocumentLoans();
	//archive
	List<ArchiveDocumentResponse> getDocArchives();
	List<ArchiveLaptopResponse> getLapArchives();
	List<ArchiveDocumentResponse> archiveDocumentSearch(String search);
	List<ArchiveLaptopResponse> archiveLaptopSearch(String search);
}
