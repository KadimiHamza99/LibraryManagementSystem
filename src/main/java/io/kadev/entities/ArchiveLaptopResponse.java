package io.kadev.entities;

import java.time.LocalDate;

import io.kadev.entities.enums.BrandEnum;
import io.kadev.entities.enums.StateEnum;
import io.kadev.entities.enums.SubscriptionTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class ArchiveLaptopResponse {
	private BrandEnum brand;
	private boolean isAvailable;
	private String adherentName;
	private SubscriptionTypeEnum subscriptionType;
	private LocalDate loanDate;
	private LocalDate returnDate;
	private StateEnum state;
}
