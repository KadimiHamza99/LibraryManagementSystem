package io.kadev.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.kadev.entities.Document;

public interface DocumentRepository extends JpaRepository<Document, Long>{

}
