package io.kadev.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.kadev.entities.Adherent;

@Repository
public interface AdherentRepository extends JpaRepository<Adherent, Long>{

}
