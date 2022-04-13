package io.kadev.entities;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data @NoArgsConstructor @AllArgsConstructor @ToString
@Entity
@Table(name="DOCUMENTS")
public class Document {
	@Id
	private String idDocument;
	private String title;
	private String author;
	private boolean available;
	private String state;
//	private List<Loan> loans;
	
	public Document(String t,String a,String s) {
		this.idDocument=UUID.randomUUID().toString();
		this.title=t;
		this.author=a;
		this.available=true;
		this.state=s;
//		this.loans=null;
	}
}
