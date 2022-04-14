package io.kadev;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.kadev.entities.Adherent;
import io.kadev.entities.Laptop;
import io.kadev.entities.LoanLaptop;
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
	
			Stream.of(hamza,salma,karim).forEach(a->{
				lsi.addAdherent(a);
			});
			Stream.of(lap1,lap2,lap3,lap4).forEach(l->{
				lsi.addLaptop(l);
			});	
			lsi.loanLaptop(karim, lap4);
			lsi.loanLaptop(hamza, lap3);
			lsi.loanLaptop(salma, lap1);
//			lsi.returnLaptop(karim, lap4);
			lsi.loanLaptop(karim, lap2);
			
			List<LoanLaptop> lls = lsi.getAllLaptopLoans();
			for (LoanLaptop ll : lls) {
				System.out.println(ll.getLaptop().getBrand());
			}
		};
	}

}
