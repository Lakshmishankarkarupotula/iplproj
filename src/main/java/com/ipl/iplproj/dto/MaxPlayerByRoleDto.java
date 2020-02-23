package com.ipl.iplproj.dto;

import java.util.List;

import com.ipl.iplproj.model.Player;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MaxPlayerByRoleDto {

//	private String label;
//	private String playerName;
//	private String playerRole;
//	private Long playerPrice;
//	
	private String role;	
	private long amount;
	private List<Player> players;
	
}
