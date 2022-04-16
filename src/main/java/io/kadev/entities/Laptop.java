package io.kadev.entities;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.kadev.entities.enums.BrandEnum;
import io.kadev.entities.enums.StateEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data @NoArgsConstructor @AllArgsConstructor @ToString
@Entity
@Table(name="LAPTOPS")
public class Laptop {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idLaptop;
	@Enumerated(EnumType.STRING)
	private BrandEnum brand;
	private boolean outOfOrder;
	private boolean available;
	@Enumerated(EnumType.STRING)
	private StateEnum state;
	@OneToOne(mappedBy="laptop")
//	@JsonProperty(access = Access.READ_ONLY)
	@JsonIgnore
	private LoanLaptop loanLap;
	
	
	public Laptop(BrandEnum b,StateEnum s) {
		this.brand=b;
		this.outOfOrder=false;
		this.available=true;
		this.state=s;
		this.loanLap=null;
	}

}
