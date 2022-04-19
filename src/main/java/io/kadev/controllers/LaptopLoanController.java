package io.kadev.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.kadev.entities.LoanLaptop;
import io.kadev.services.LibraryServiceImpl;

@RestController
@RequestMapping("/laptops_loans")
public class LaptopLoanController {
	@Autowired
	private LibraryServiceImpl lsi;
	@GetMapping("get")
	public List<LoanLaptop> getLaptopsLoans(){
		return lsi.getAllLaptopLoans();
	}
}
