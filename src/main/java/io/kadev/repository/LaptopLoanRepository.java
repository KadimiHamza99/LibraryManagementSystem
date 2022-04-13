package io.kadev.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import io.kadev.entities.Laptop;
import io.kadev.entities.LoanLaptop;

public interface LaptopLoanRepository extends JpaRepository<LoanLaptop, String>{
	List<LoanLaptop> findByLaptop(Laptop laptop);
//	LoanLaptop findTopByLaptop(Laptop laptop);
}
