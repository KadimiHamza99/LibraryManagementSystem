package io.kadev.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.kadev.entities.enums.StateEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data @NoArgsConstructor @AllArgsConstructor @ToString
@Entity
@Table(name="DOCUMENTS")
public class Document {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idDocument;
	private String title;
	private String author;
	private boolean available;
	private StateEnum state;
	@JsonIgnore
	@OneToOne(mappedBy = "document",cascade = CascadeType.ALL)
	private LoanDocument loanDocument;
	
	public Document(String t,String a,StateEnum state) {
		this.title=t;
		this.author=a;
		this.available=true;
		this.state=state;
		this.loanDocument=null;
	}
	
}
