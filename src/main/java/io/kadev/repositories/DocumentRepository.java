package io.kadev.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import io.kadev.entities.Document;

public interface DocumentRepository extends JpaRepository<Document, Long>{

}
