package io.kadev.entities;

import java.time.LocalDate;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import io.kadev.entities.enums.SubscriptionTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data @NoArgsConstructor @AllArgsConstructor @ToString
@Entity
@Table(name="ADHERENTS")
public class Adherent {
	@Id
	private String idAdherent;
	@Column(length=20)
	private String fullName;
	@Column(length=7,unique=true)
	private String cin;
	private LocalDate subscriptionDate;
	private LocalDate expirationMembershipDate;
	@Enumerated(EnumType.STRING)
	private SubscriptionTypeEnum subscriptionType;
//	private List<Loan> loans;
	@OneToOne(mappedBy = "adherent")
	@JsonProperty(access = Access.READ_ONLY)
	private LoanLaptop loanLaptop;
	
	public Adherent(String fn,String cin,SubscriptionTypeEnum st) {
		this.idAdherent=UUID.randomUUID().toString();
		this.fullName=fn;
		this.cin=cin;
		this.subscriptionDate=LocalDate.now();
		this.expirationMembershipDate=this.subscriptionDate.plusYears(1L);
		this.subscriptionType=st;
		this.loanLaptop=null;
	}
	
}
