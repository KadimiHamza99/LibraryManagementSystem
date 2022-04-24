package io.kadev.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.kadev.entities.LoanLaptop;
import io.kadev.entities.enums.StateEnum;
import io.kadev.services.LibraryServiceImpl;

@RestController
@RequestMapping("/laptops_loans")
public class LaptopLoanController {
	@Autowired
	private LibraryServiceImpl lsi;
	
	@PostMapping("/loan/lap")
	public void loanDocument(@RequestParam Long idAdh
							,@RequestParam Long idLap) {
		lsi.loanLaptop(idAdh, idLap);
	}
	
	@PostMapping("/return/lap")
	public void returnDocument(@RequestParam Long idAdh
							  ,@RequestParam Long idLap
							  ,@RequestParam String state) {
		StateEnum st = null;
		StateEnum[] states = StateEnum.values();
		for (StateEnum s : states) {
			if(s.toString().equals(state)) st = s;
		}
		lsi.returnLaptop(idAdh, idLap, st);
	}
	
	
	@GetMapping("get")
	public List<LoanLaptop> getLaptopsLoans(){
		return lsi.getAllLaptopLoans();
	}
}
