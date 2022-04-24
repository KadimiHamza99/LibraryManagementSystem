package io.kadev;

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
import io.kadev.services.LibraryServiceImpl;

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
			Adherent fatiha = new Adherent("BENSAID Fatiha","Y466139",SubscriptionTypeEnum.PREMIUM);
			Adherent kawtar = new Adherent("KHAMINI Kawtar","K632232",SubscriptionTypeEnum.STANDARD);
			Adherent ali = new Adherent("BENSALEH Ali","L882892",SubscriptionTypeEnum.STANDARD);
			
			Laptop lap1 = new Laptop(BrandEnum.ACER,StateEnum.GOOD);
			Laptop lap2 = new Laptop(BrandEnum.HP,StateEnum.VERY_GOOD);
			Laptop lap3 = new Laptop(BrandEnum.LENOVO,StateEnum.NORMAL);
			Laptop lap4 = new Laptop(BrandEnum.MAC,StateEnum.VERY_BAD);
			Laptop lap5 = new Laptop(BrandEnum.DELL,StateEnum.VERY_GOOD);
			Laptop lap6 = new Laptop(BrandEnum.XIAOMI,StateEnum.VERY_BAD);
			Laptop lap7 = new Laptop(BrandEnum.ASUS,StateEnum.NORMAL);
			Laptop lap8 = new Laptop(BrandEnum.TOSHIBA,StateEnum.NORMAL);
			
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
			Document doc11 = new Document("MONGODB","BAHAR LOP",StateEnum.GOOD);
			Document doc12 = new Document("JEE","JHON PAUL",StateEnum.VERY_GOOD);
			Document doc13 = new Document("JAVASCRIPT","FREDERIK",StateEnum.GOOD);
			Document doc14 = new Document("NODEJS","MOSH",StateEnum.BAD);
			Document doc15 = new Document("SVELTJS","MOSH",StateEnum.NORMAL);
			Document doc16 = new Document("AXIOS","IBRAHIM",StateEnum.GOOD);
	
			Stream.of(hamza,salma,karim,fatiha,kawtar,ali).forEach(a->{
				lsi.addAdherent(a);
			});
			Stream.of(lap1,lap2,lap3,lap4,lap5,lap6,lap7,lap8).forEach(l->{
				lsi.addLaptop(l);
			});	
			Stream.of(doc1,doc2,doc3,doc4,doc5,doc6,doc8,doc7,doc9,doc10,doc11,doc12,doc13,doc14,doc15,doc16).forEach(l->{
				lsi.addDocument(l);
			});	

		};
	}

}
