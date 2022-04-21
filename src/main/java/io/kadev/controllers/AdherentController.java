package io.kadev.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.kadev.entities.Adherent;
import io.kadev.entities.enums.SubscriptionTypeEnum;
import io.kadev.services.LibraryServiceImpl;

@RestController
@RequestMapping("/adherents")
public class AdherentController {
	@Autowired
	private LibraryServiceImpl lsi;
	
	@PostMapping("/add")
	public void addAdherent(@RequestBody Adherent adh,
							  @RequestParam String subType) {
		SubscriptionTypeEnum ste = 
				SubscriptionTypeEnum.PREMIUM.toString().equals(subType) ? 
						SubscriptionTypeEnum.PREMIUM : SubscriptionTypeEnum.STANDARD;
		Adherent adherent = new Adherent(adh.getFullName(),adh.getCin(),ste);
		lsi.addAdherent(adherent);
	}
	
	@DeleteMapping("/delete/{idAdherent}")
	public void removeAdherent(@PathVariable("idAdherent") Long idAdherent) {
		lsi.removeAdherent(idAdherent);
	}
	
	@PutMapping("/extend/{idAdherent}")
	public void extendMembership(@PathVariable Long idAdherent,
								 @RequestParam String subType) {
		Adherent adh = lsi.getAdherent(idAdherent);
		LocalDate extendDate = adh.getExpirationMembershipDate().plusYears(1L);
		SubscriptionTypeEnum ste = 
				SubscriptionTypeEnum.PREMIUM.toString().equals(subType) ? 
						SubscriptionTypeEnum.PREMIUM : SubscriptionTypeEnum.STANDARD;
		lsi.extendMembershipAdherent(idAdherent, extendDate, ste);
	}
	
	@GetMapping("/get")
	public List<Adherent> getAllAdherents(){
		return lsi.getAdherents();
	}
}
