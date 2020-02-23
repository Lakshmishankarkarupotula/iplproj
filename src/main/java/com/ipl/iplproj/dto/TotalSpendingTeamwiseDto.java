package com.ipl.iplproj.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class TotalSpendingTeamwiseDto {
	
	private String label;
	private long totalAmountSpent;
	public TotalSpendingTeamwiseDto(String label, long totalAmountSpent) {
		super();
		this.label = label;
		this.totalAmountSpent = totalAmountSpent;
	}

	
}
