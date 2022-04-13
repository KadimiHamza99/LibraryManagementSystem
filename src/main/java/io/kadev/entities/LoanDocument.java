package io.kadev.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data @NoArgsConstructor @AllArgsConstructor @ToString
@Entity
@Table(name="LOANS")
public class LoanDocument {
	@Id
	private String idLoan;
//	private Adherent adherent;
//	private List<Document> documents;

	private LocalDate LoanDate;

	private LocalDate returnDate;

//	public Loan(Adherent a,List<Document> d) {
//		this.idLoan=UUID.randomUUID().toString();
//		this.adherent=a;
//		this.documents=d;
//		this.LoanDate=LocalDate.now();
//		this.returnDate = this.adherent.getSubscriptionType().equals("Premium") ? 
//				this.LoanDate.plusDays(30L):this.LoanDate.plusDays(15L) ; 
//	}
}
