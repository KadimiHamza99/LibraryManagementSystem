package io.kadev.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import io.kadev.entities.Adherent;
import io.kadev.entities.Document;
import io.kadev.entities.LoanDocument;

public interface LoanDocumentRepository extends JpaRepository<LoanDocument, Long>{

	List<LoanDocument> findByDocument(Document document);

	List<LoanDocument> findByAdherent(Adherent adherent);
}
