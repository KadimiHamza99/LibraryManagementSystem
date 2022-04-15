package io.kadev.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idLoanArchive;
	private Long idProduct;
	private Long adherentId;
	private LocalDate loanDate;
	private LocalDate returnDate;
	private String typeProduct;
	
	public LoanArchive(Long ip,Long an,LocalDate ld,LocalDate rd,String tp) {
		this.idProduct=ip;
		this.adherentId=an;
		this.loanDate=ld;
		this.returnDate=rd;
		this.typeProduct=tp;
	}
	

}
