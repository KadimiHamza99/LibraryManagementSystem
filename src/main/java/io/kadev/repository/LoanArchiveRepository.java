package io.kadev.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.kadev.entities.LoanArchive;

public interface LoanArchiveRepository extends JpaRepository<LoanArchive, Long>{

}
