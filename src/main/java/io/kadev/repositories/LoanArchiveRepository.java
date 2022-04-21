package io.kadev.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import io.kadev.entities.LoanArchive;

public interface LoanArchiveRepository extends JpaRepository<LoanArchive, Long>{
	
}
