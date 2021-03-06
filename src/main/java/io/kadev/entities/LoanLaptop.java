package io.kadev.entities;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import io.kadev.entities.enums.SubscriptionTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data @NoArgsConstructor @AllArgsConstructor @ToString
@Entity
@Table(name="LOAN_LAPTOPS")
public class LoanLaptop {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idLoanLap;
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="adherent_id")
	private Adherent adherent;
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="laptop_id")
	private Laptop laptop;
	private LocalDate loanDate;
	private LocalDate returnDate;
	private boolean isLoanExpired;
	
	public LoanLaptop(Adherent a,Laptop l) {
		this.adherent=a;
		this.laptop=l;
		this.loanDate=LocalDate.now();
		this.returnDate= this.adherent.getSubscriptionType().equals(SubscriptionTypeEnum.PREMIUM) ? 
				LocalDate.now().plusDays(2L) : LocalDate.now().plus(1L,ChronoUnit.DAYS);
		this.isLoanExpired=false;
	}
}
