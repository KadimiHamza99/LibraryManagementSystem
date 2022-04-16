package io.kadev.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import io.kadev.entities.enums.SubscriptionTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data @AllArgsConstructor @NoArgsConstructor @ToString
@Entity
@Table(name="LOAN_DOCUMENTS")
public class LoanDocument {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idLoanDocument;
	@ManyToOne
	private Adherent adherent;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="document_id")
	private Document document;

	private LocalDate LoanDate;
	private LocalDate returnDate;
	private boolean isLoanExpired;
	
	public LoanDocument(Adherent adherent,Document document) {
		this.adherent=adherent;
		this.document=document;
		this.LoanDate=LocalDate.now();
		this.returnDate=adherent.getSubscriptionType().
				equals(SubscriptionTypeEnum.PREMIUM) ? LocalDate.now().plusMonths(1L) : LocalDate.now().plusDays(14L);
		this.isLoanExpired=false;
	}

}
