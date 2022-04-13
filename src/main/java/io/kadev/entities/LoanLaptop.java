package io.kadev.entities;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.FetchType;
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
	@Id
	private String idLoanLap;
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="adherent_id")
	private Adherent adherent;
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="laptop_id")
	private Laptop laptop;
	private LocalDate returnDate;
	
	public LoanLaptop(Adherent a,Laptop l) {
		this.idLoanLap=UUID.randomUUID().toString();
		this.adherent=a;
		this.laptop=l;
		this.returnDate= this.adherent.getSubscriptionType().equals(SubscriptionTypeEnum.PREMIUM) ? 
				LocalDate.now().plusDays(7L) : LocalDate.now().plus(1,ChronoUnit.DAYS);
	}
}
