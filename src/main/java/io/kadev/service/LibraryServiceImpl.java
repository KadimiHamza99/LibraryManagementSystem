package io.kadev.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.kadev.entities.Adherent;
import io.kadev.entities.Document;
import io.kadev.entities.Laptop;
import io.kadev.entities.LoanArchive;
import io.kadev.entities.LoanDocument;
import io.kadev.entities.LoanLaptop;
import io.kadev.repository.AdherentRepository;
import io.kadev.repository.DocumentRepository;
import io.kadev.repository.LaptopLoanRepository;
import io.kadev.repository.LaptopRepository;
import io.kadev.repository.LoanArchiveRepository;
import io.kadev.repository.LoanDocumentRepository;
import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class LibraryServiceImpl implements ILibraryService {

	@Autowired
	private AdherentRepository adherentRepo;
	@Autowired
	private LaptopRepository laptopRepo;
	@Autowired
	private LaptopLoanRepository laptopLoanRepo;
	@Autowired
	private LoanArchiveRepository loanArchiveRepo;
	@Autowired
	private LoanDocumentRepository loanDocumentRepo;
	@Autowired
	private DocumentRepository documentRepo;

	@Override
	public void addAdherent(Adherent a) {
		adherentRepo.save(a);
	}

	@Override
	public void removeAdherent(Adherent a) {
		adherentRepo.delete(a);
	}

	@Override
	public void addLaptop(Laptop l) {
		laptopRepo.save(l);
	}

	@Override
	public void removeLaptop(Laptop l) {
		laptopRepo.delete(l);
	}
	@Override
	public void addDocument(Document d) {
		documentRepo.save(d);
	}
	@Override
	public void removeDocument(Document d) {
		documentRepo.delete(d);
	}
	
	@Override
	// effectuer l'operation d'emprunt
	public void loanLaptop(Adherent a, Laptop l) {
		if (l.getLoanLap() == null) {
			/*
			 * verifier si le PC est disponible et qu il nest pas en panne ainsi que la date
			 * d'adhesion n'est pas encore terminé
			 */
			if (l.isAvailable() && !l.isOutOfOrder() && a.getLoanLaptop() == null
					&& LocalDate.now().isBefore(a.getExpirationMembershipDate())) {
				LoanLaptop ll = new LoanLaptop(a, l);
				a.setLoanLaptop(ll);
				l.setLoanLap(ll);
				l.setAvailable(false);
				laptopLoanRepo.save(ll);
				LoanArchive archive = new LoanArchive(ll.getLaptop().getIdLaptop(),
						ll.getAdherent().getIdAdherent(), LocalDate.now(), ll.getReturnDate(), "laptop");
				loanArchiveRepo.save(archive);
			}
		}
	}

	// Methode pour rendre les pc portables empruntés
	@Override
	public void returnLaptop(Adherent a, Laptop l) {
		// condition pour checker que le pc est effectivement emprunter ainsi que
		// l'adherent emprunt deja un pc
		if (!l.isAvailable() && a.getLoanLaptop() != null) {
			LoanLaptop lloanLaptop = laptopLoanRepo.findByLaptop(l).get(0);
			LoanLaptop aloanLaptop = a.getLoanLaptop();
			// verifier que le pc emprunter par l'adherent est le meme que le pc passer par
			// les args de la methode
			if (lloanLaptop.getIdLoanLap().equals(aloanLaptop.getIdLoanLap())) {
				a.setLoanLaptop(null);
				l.setLoanLap(null);
				l.setAvailable(true);
				laptopLoanRepo.deleteById(lloanLaptop.getIdLoanLap());
			}
		}
	}

	// Return a list of laptops loans in progress and check if someone have exceeded
	// the loaning time
	public List<LoanLaptop> getAllLaptopLoans() {
		List<LoanLaptop> returnlls = new ArrayList<LoanLaptop>();
		laptopLoanRepo.findAll().forEach(ll -> {
			ll.setLoanExpired(LocalDate.now().isAfter(ll.getReturnDate()) ? true : false);
			returnlls.add(ll);
		});
		return returnlls;
	}
	
	@Override
	public void loanDocument(Adherent adherent, Document document) {
		LoanDocument ld = new LoanDocument(adherent,document);
		document.setAvailable(false);
		document.setLoanDocument(ld);
		adherent.getLoanDocument().add(ld);
		documentRepo.save(document);
	}
	
	static int totalNumberDocuments=0;
	static int loanedDocumentsNumber=0;
	@Override
	/*
	 * effectuer l'operation d'emprunt des documents :
	 * tout d'abord je verifie que les documents passer en arguments sont disponibles et apres je met le nombre des documents empruntés par
	 * l'adherent dans la variable loanedDocuments pour checker que l'adherent n'a pas depasser le nombre limite des emprunts et je verifie
	 * aussi que la duree d'abonnement n'est pas encorre depasser , et apres je verifie que le nombre des documents deja emprunté plus le 
	 * nombre des documents qu il veut emprunter ne depasse pas le nombre limite des documents (je verifie aussi si le type d'abonnement est
	 * PREMIUM ou STANDARD
	 * */
	public void loanDocuments(Adherent adherent, List<Document> documents) {
		
		
		documents.forEach(d->{
			loanDocument(adherent, d);
		});
		
		
		
		
//		LibraryServiceImpl.totalNumberDocuments=0;
//		LibraryServiceImpl.loanedDocumentsNumber=0;
//		List<Document> availableDocs = documents.stream().filter(d -> d.isAvailable())
//					.collect(Collectors.toList());
//		LoanDocument ld = new LoanDocument(adherent,availableDocs);
//		adherent.getLoanDocument().forEach(l->{
//			loanedDocumentsNumber+=l.getDocuments().size();
//		});
//		int authorizedNumber = adherent.getSubscriptionType().equals(SubscriptionTypeEnum.PREMIUM) ? 14 : 7;
//		if (LocalDate.now().isBefore(adherent.getExpirationMembershipDate()) && loanedDocumentsNumber<authorizedNumber) {
//			adherent.getLoanDocument().forEach(l->{
//				totalNumberDocuments+=l.getDocuments().size();
//			});
//			totalNumberDocuments+=availableDocs.size();
//			if(totalNumberDocuments<=authorizedNumber) {
//				availableDocs.forEach(d->{
//					d.setAvailable(false);
//					d.setLoanDocument(ld);
//				});
//				documentRepo.saveAll(availableDocs);
//				loanDocumentRepo.save(ld);
//				availableDocs.forEach(d->{
//					LoanArchive archive = new LoanArchive(d.getIdDocument()
//									,adherent.getIdAdherent()
//									,LocalDate.now()
//									,ld.getReturnDate()
//									,"document");
//					loanArchiveRepo.save(archive);
//				});
//			}
//		}
	}
	@Override
	public void returnDocuments(Adherent adherent,List<Document> documents) {

	}

	@Override
	public List<LoanDocument> getAllDocumentLoans() {
		return null;
	}

	@Override
	public void returnDocument(Adherent adherent, Document document) {
		// TODO Auto-generated method stub
		
	}


}
