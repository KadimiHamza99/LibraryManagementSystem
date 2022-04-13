package io.kadev.service;

import java.time.LocalDate;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.kadev.entities.Adherent;
import io.kadev.entities.Laptop;
import io.kadev.entities.LoanArchive;
import io.kadev.entities.LoanLaptop;
import io.kadev.repository.AdherentRepository;
import io.kadev.repository.LaptopLoanRepository;
import io.kadev.repository.LaptopRepository;
import io.kadev.repository.LoanArchiveRepository;
import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class LibraryServiceImpl implements ILibraryService{

	@Autowired
	private AdherentRepository adherentRepo;
	@Autowired
	private LaptopRepository laptopRepo;
	@Autowired
	private LaptopLoanRepository laptopLoanRepo;
	@Autowired
	private LoanArchiveRepository loanArchiveRepo;
	
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
	public void loanLaptop(Adherent a, Laptop l) {
		if(l.getLoanLap()==null) {
			/*
			 * verifier si le PC est disponible et qu il nest pas en panne ainsi que la date d'adhesion n'est pas
			 * encore terminé
			*/
			if(l.isAvailable() && !l.isOutOfOrder() && a.getLoanLaptop()==null
					&& LocalDate.now().isBefore(a.getExpirationMembershipDate())) {
				LoanLaptop ll = new LoanLaptop(a,l);
				a.setLoanLaptop(ll);
				l.setLoanLap(ll);;
				l.setAvailable(false);
				laptopLoanRepo.save(ll);
				LoanArchive archive = new LoanArchive(ll.getLaptop().getIdLaptop().toString()
													, ll.getAdherent().getIdAdherent()
													, LocalDate.now()
													, ll.getReturnDate()
									);
				loanArchiveRepo.save(archive);
			}
		}
	}
	@Override
	public void returnLaptop(Adherent a, Laptop l) {
		if(!l.isAvailable() && a.getLoanLaptop()!=null) {
			LoanLaptop lloanLaptop = laptopLoanRepo.findByLaptop(l).get(0);
			LoanLaptop aloanLaptop = a.getLoanLaptop();
			if(lloanLaptop.getIdLoanLap().equals(aloanLaptop.getIdLoanLap())) {
				System.out.println("RETURN FUNCT");
				a.setLoanLaptop(null);
				l.setLoanLap(null);
				l.setAvailable(true);
				laptopLoanRepo.deleteById(lloanLaptop.getIdLoanLap());
			}
		}
	}
}
