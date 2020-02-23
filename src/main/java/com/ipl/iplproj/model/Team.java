package com.ipl.iplproj.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class Team {
	
	@Id
	private String id;
	private String city;
	private String coach;
	private String home;
	private String team;
	private String label;
	@Autowired
	private List<Player> players;

	public Team() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	
//	public static class Builder{
//		
//		private String id;
//		private String city;
//		private String coach;
//		private String home;
//		private String team;
//		private String label;
//		
//		private List<Player> players;
//
//		public Builder(String id,List<Player> players) {
//			this.setId(id);
//			this.setPlayers(players);
//		}
//		
//		public Builder fromCity(String city) {
//			this.city = city;
//			
//			return this;
//		}		
//		
//		public Builder hasCoach(String coach) {
//			this.coach= coach;
//			
//			return this;
//		}
//		
//		public Builder atHome(String home) {
//			this.home= home;
//			
//			return this;
//		}		
//		
//		public Builder inTeam(String team) {
//			this.team= team;
//			
//			return this;
//		}
//		
//		public Builder ofLabel(String label) {
//			this.label = label;
//			
//			return this;
//		}
//	
//		public Team build() {
//			
//			Team team = new Team();
//			team.city = this.city;
//			team.coach = this.coach;
//			team.home = this.home;
//			team.team = this.team;
//			team.label = this.label;
//			return team;
//			
//			
//		}
//
//		public String getId() {
//			return id;
//		}
//
//		public void setId(String id) {
//			this.id = id;
//		}
//
//		public List<Player> getPlayers() {
//			return players;
//		}
//
//		public void setPlayers(List<Player> players) {
//			this.players = players;
//		}
//		
//	}
	
	
}
