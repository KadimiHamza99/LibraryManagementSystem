package io.kadev.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.kadev.entities.enums.SubscriptionTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data @NoArgsConstructor @AllArgsConstructor @ToString
@Entity
@Table(name="ADHERENTS")
public class Adherent {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAdherent;
	@Column(length=20)
	private String fullName;
	@Column(length=7,unique=true)
	private String cin;
	private LocalDate subscriptionDate;
	private LocalDate expirationMembershipDate;
	@Enumerated(EnumType.STRING)
	private SubscriptionTypeEnum subscriptionType;
	@OneToOne(mappedBy = "adherent")
//	@JsonProperty(access = Access.READ_ONLY)
	@JsonIgnore
	private LoanLaptop loanLaptop;
	@OneToMany(mappedBy="adherent",fetch = FetchType.EAGER)
	@JsonIgnore
	private List<LoanDocument> loanDocument = new ArrayList<LoanDocument>();

	
	public Adherent(String fn,String cin,SubscriptionTypeEnum st) {
		this.fullName=fn;
		this.cin=cin;
		this.subscriptionDate=LocalDate.now();
		this.expirationMembershipDate=this.subscriptionDate.plusYears(1L);
		this.subscriptionType=st;
		this.loanLaptop=null;
	}
	
}
