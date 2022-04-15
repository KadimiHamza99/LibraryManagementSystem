package io.kadev.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.kadev.entities.LoanDocument;

public interface LoanDocumentRepository extends JpaRepository<LoanDocument, Long>{

}
