package io.kadev.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import io.kadev.entities.enums.StateEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data @NoArgsConstructor @AllArgsConstructor @ToString
@Entity
@Table(name="DOCUMENTS")
public class Document {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idDocument;
	private String title;
	private String author;
	private boolean available;
	private StateEnum state;
//	@ManyToMany(mappedBy="documents",fetch = FetchType.EAGER)
	@ManyToMany(fetch = FetchType.EAGER,mappedBy = "documents")
	private List<LoanDocument> loanDocument = new ArrayList<LoanDocument>();
	
	public Document(String t,String a,StateEnum state) {
		this.title=t;
		this.author=a;
		this.available=true;
		this.state=state;
	}
	
}
