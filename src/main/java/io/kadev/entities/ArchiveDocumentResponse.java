package io.kadev.entities;

import java.time.LocalDate;

import io.kadev.entities.enums.StateEnum;
import io.kadev.entities.enums.SubscriptionTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class ArchiveDocumentResponse {
	private String title;
	private String author;
	private String adherentName;
	private SubscriptionTypeEnum subscriptionType;
	private LocalDate loanDate;
	private LocalDate returnDate;
	private StateEnum state;
}
