package io.kadev;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.kadev.entities.Adherent;
import io.kadev.entities.Document;
import io.kadev.entities.Laptop;
import io.kadev.entities.enums.BrandEnum;
import io.kadev.entities.enums.StateEnum;
import io.kadev.entities.enums.SubscriptionTypeEnum;
import io.kadev.service.LibraryServiceImpl;

@SpringBootApplication
public class LibraryManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryManagementApplication.class, args);
	}
	@Bean
	CommandLineRunner start(LibraryServiceImpl lsi) {
		return args->{
			Adherent hamza = new Adherent("KADIMI Hamza","X401132",SubscriptionTypeEnum.PREMIUM);
			Adherent salma = new Adherent("FARAH Salma","T618293",SubscriptionTypeEnum.STANDARD);
			Adherent karim = new Adherent("BAADI Karim","U881392",SubscriptionTypeEnum.STANDARD);
			
			Laptop lap1 = new Laptop(BrandEnum.ACER,StateEnum.GOOD);
			Laptop lap2 = new Laptop(BrandEnum.HP,StateEnum.VERY_GOOD);
			Laptop lap3 = new Laptop(BrandEnum.LENOVO,StateEnum.NORMAL);
			Laptop lap4 = new Laptop(BrandEnum.MAC,StateEnum.VERY_BAD);
			
			Document doc1 = new Document("JAVA BRAINS","BAHAR LOP",StateEnum.GOOD);
			Document doc2 = new Document("LARAVEL","JHON PAUL",StateEnum.VERY_GOOD);
			Document doc3 = new Document("ANGULAR FOR DEVS","FREDERIK",StateEnum.GOOD);
			Document doc4 = new Document("JQUERY","MOSH",StateEnum.BAD);
			Document doc5 = new Document("REACTJS","MOSH",StateEnum.NORMAL);
			Document doc6 = new Document("AJAX","IBRAHIM",StateEnum.GOOD);
			Document doc7 = new Document("ORACLE","CHAOUI",StateEnum.VERY_BAD);
			Document doc8 = new Document("MYSQL","SAMI MORAD",StateEnum.GOOD);
			Document doc9 = new Document("PHP NOTES FOR PROFESSIONALS","MOSH",StateEnum.NORMAL);
			Document doc10 = new Document("OOP FOR DUMBS","CHAOUI",StateEnum.NORMAL);
	
			Stream.of(hamza,salma,karim).forEach(a->{
				lsi.addAdherent(a);
			});
			Stream.of(lap1,lap2,lap3,lap4).forEach(l->{
				lsi.addLaptop(l);
			});	
			Stream.of(doc1,doc2,doc3,doc4,doc5,doc6,doc8,doc7,doc9,doc10).forEach(l->{
				lsi.addDocument(l);
			});	

			lsi.loanLaptop(karim, lap4);
			lsi.loanLaptop(hamza, lap3);
			lsi.loanLaptop(salma, lap1);
//			lsi.returnLaptop(karim, lap4);
			lsi.loanLaptop(karim, lap2);
			
			List<Document> docsToLoan = new ArrayList<Document>(List.of(doc1,doc4,doc7,doc9));
//			lsi.loanDocument(karim, doc1);
//			lsi.loanDocument(karim, doc4);
//			lsi.loanDocument(karim, doc8);
			lsi.loanDocuments(karim, docsToLoan);
//			List<Document> docsToLoan1 = new ArrayList<Document>(List.of(doc2,doc3));
//			lsi.loanDocuments(karim, docsToLoan1);
//			List<Document> docsToLoan2 = new ArrayList<Document>(List.of(doc5,doc6));
//			lsi.loanDocuments(hamza, docsToLoan2);
			
//			List<LoanLaptop> lls = lsi.getAllLaptopLoans();
//			for (LoanLaptop ll : lls) {
//				System.out.println(ll.getLaptop().getBrand());
//			}
		};
	}

}
