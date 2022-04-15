package io.kadev.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import io.kadev.entities.enums.SubscriptionTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data @NoArgsConstructor @AllArgsConstructor @ToString
@Entity
@Table(name="LOAN_DOCUMENTS")
public class LoanDocument {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idLoanDocument;
	@ManyToOne
	private Adherent adherent;
//	@ManyToMany(fetch = FetchType.EAGER)
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="LOAN_DOCUMENTS__DOCUMENTS",
			   joinColumns = {@JoinColumn(name="loan_document_id")},
			   inverseJoinColumns = {@JoinColumn(name="document_id")} 
			  )
	private List<Document> documents = new ArrayList<Document>();

	private LocalDate LoanDate;
	private LocalDate returnDate;
	private boolean isLoanExpired;
	
	public LoanDocument(Adherent adherent,List<Document> documents) {
		this.adherent=adherent;
		this.LoanDate=LocalDate.now();
		this.returnDate=adherent.getSubscriptionType().
				equals(SubscriptionTypeEnum.PREMIUM) ? LocalDate.now().plusMonths(1L) : LocalDate.now().plusDays(14L);
		this.isLoanExpired=false;
	}

}
