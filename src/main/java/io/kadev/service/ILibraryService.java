package io.kadev.service;

import io.kadev.entities.Adherent;
import io.kadev.entities.Laptop;

public interface ILibraryService {
	void addAdherent(Adherent a);
	void removeAdherent(Adherent a);
	void addLaptop(Laptop l);
	void removeLaptop(Laptop l);
	void loanLaptop(Adherent a,Laptop l);
	void returnLaptop(Adherent a,Laptop l);
}
