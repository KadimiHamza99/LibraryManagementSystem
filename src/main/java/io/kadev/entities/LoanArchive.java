package io.kadev.entities;

import java.time.LocalDate;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data @NoArgsConstructor @AllArgsConstructor @ToString
@Entity
@Table(name="LOAN_ARCHIVES")
public class LoanArchive {
	@Id
	private String idLoanArchive;
	private String idProduct;
	private String adherentName;
	private LocalDate loanDate;
	private LocalDate returnDate;
	
	public LoanArchive(String ip,String an,LocalDate ld,LocalDate rd) {
		this.idLoanArchive=UUID.randomUUID().toString();
		this.idProduct=ip;
		this.adherentName=an;
		this.loanDate=ld;
		this.returnDate=rd;
	}
	

}
