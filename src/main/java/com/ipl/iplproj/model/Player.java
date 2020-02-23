package com.ipl.iplproj.model;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @EqualsAndHashCode @ToString
public class Player {
	String player;
	long price;
	String role;
	
	public Player() {
		// TODO Auto-generated constructor stub
	}

	public Player(String player, long price, String role) {
		super();
		this.player = player;
		this.price = price;
		this.role = role;
	}


	

}
