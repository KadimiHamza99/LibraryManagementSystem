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
	void removeLaptop(Long idLap);
	Laptop getLaptop(Long id);
	List<Laptop> getLaptops();
	void changeLapState(Long id,StateEnum state);
	void changeLapFunct(Long id);
	List<Laptop> getAvailableLaps();
	//document
	void addDocument(Document d);
	void removeDocument(Document d);
	List<Document> getDocuments();
	Document getDocument(Long id);
	void removeDocument(Long id);
	List<Document> getAvailableDocs();
	void changeDocState(Long id,StateEnum state);
	//loan laptop
	void loanLaptop(Adherent a,Laptop l);
	void loanLaptop(Long idAdh,Long idLap);
	void returnLaptop(Long idAdh,Long idLap,StateEnum s);
	void returnLaptop(Adherent idAdh,Laptop idLap,StateEnum s);
	List<LoanLaptop> getAllLaptopLoans();
	//loan document
	void loanDocuments(Adherent adherent, List<Document> documents);
	void loanDocuments(Long idAdherent, List<Long> idDocuments);
	void loanDocument(Adherent adherent, Document document);
	void loanDocument(Long iAdherent, Long idDocument);
	void returnDocuments(Adherent adherent, List<Document> documents);
	void returnDocument(Adherent adherent, Document document);
	void returnDocuments(Long idAdherent, List<Long> idDocuments);
	void returnDocument(Long idAdherent, Long idDocument);
	List<LoanDocument> getAllDocumentLoans();
	//archive
	List<ArchiveDocumentResponse> getDocArchives();
	List<ArchiveLaptopResponse> getLapArchives();
	List<ArchiveDocumentResponse> archiveDocumentSearch(String search);
	List<ArchiveLaptopResponse> archiveLaptopSearch(String search);
}
