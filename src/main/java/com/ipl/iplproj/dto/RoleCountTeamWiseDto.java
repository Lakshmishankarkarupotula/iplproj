package com.ipl.iplproj.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Builder
@AllArgsConstructor
public class RoleCountTeamWiseDto {

	private String playersRole;
	private int playersCount;

}
