package io.kadev.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.kadev.entities.Laptop;

@Repository
public interface LaptopRepository extends JpaRepository<Laptop, Long>{

}
