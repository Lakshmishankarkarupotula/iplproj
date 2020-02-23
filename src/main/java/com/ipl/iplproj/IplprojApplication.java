package com.ipl.iplproj;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
//import com.ipl.iplproj.repo.TeamRepository;
import com.ipl.iplproj.dao.TeamDAOimpl;
import com.ipl.iplproj.dto.*;

@SpringBootApplication
public class IplprojApplication {
	
	//@Autowired
	//private TeamRepository teamRepository;
	@Autowired
	private TeamDAOimpl teamDAOimpl;

	public static void main(String[] args) {
		SpringApplication.run(IplprojApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner runner() {
		return (args) -> {
		
			
//			List<Team> teams = teamRepository.findAll();
//			System.out.println(teams.size());
//			
//			List<TeamLabelDto> allLabels = teamDAOimpl.getTeamLabels();
//			
//			for (TeamLabelDto teamLabelDto : allLabels) {
//				System.out.println(teamLabelDto.getLabel());
//			}
//			
//			System.out.println("1------------------");
//			
//			List<PlayersNameTeamWiseDto> allPlayersList = teamDAOimpl.getPlayerNameTeamWise("CSK");
//			
//			for (PlayersNameTeamWiseDto allPlayers : allPlayersList) {
//				System.out.println(allPlayers.getPlayerName() +"\t and role is :" + allPlayers.getPlayerRole()+ " price is : " +allPlayers.getPlayerPrice());
//			}
//			
//			System.out.println("2------------------");
//			
//			List<TeamDetailsDto> details = teamDAOimpl.getTeamDetailsList();
//			
//			for (TeamDetailsDto teamDetails : details) {
//				System.out.println(teamDetails.getLabel() + "\t HOME : " + teamDetails.getHome() + " and COACH : " + teamDetails.getCoach());
//			}
//			
//			System.out.println("3------------------");
//			
//			
//			List<RoleCountTeamWiseDto> roleCount = teamDAOimpl.getRoleCountTeamWise("CSK");
//			for (RoleCountTeamWiseDto result : roleCount) {
//				System.out.println("Player Role -> " + result.getPlayersRole() + " count is " + result.getPlayersCount() );
//			}
//			
//			System.out.println("4------------------");
//			
//			
//			List<RoleStatisticsTeamwiseDto> roleStats = teamDAOimpl.getRoleStatisticsTeamwise("CSK");
//			
//			for (RoleStatisticsTeamwiseDto result : roleStats) {
//				System.out.println("For -> " + result.getPlayersRole() + " Total amount spent is : " + result.getTotalAmount() );
//			}
//			
//			System.out.println("5------------------");
//			
//			
//			List<SortPlayerBySalaryDto> sortedPlayers = teamDAOimpl.getPlayerBySalarySorted("CSK");
//			
//			for (SortPlayerBySalaryDto result : sortedPlayers) {
//				System.out.println(result.getPlayerName() +" " + result.getLabel() + " " + result.getPlayerRole() +" " + result.getPlayerPrice());
//			}
//			
//			System.out.println("6------------------SortPlayerBySalaryDto");
//			
//			
//			List<MaxPlayerByRoleDto> byRoleDtos = teamDAOimpl.getMaxPlayerByRole();
//			for (MaxPlayerByRoleDto result : byRoleDtos) {
//				
//				System.out.println(result.getPlayers() + " " + result.getRole() +" " + result.getAmount()); 
//			}
			
//			List<MaxPlayerByRoleDto> maxPlayer = teamDAOimpl.getMaxPlayerByRole("Batsman");
//			
//
//			System.out.println(maxPlayer.get(0).getPlayerName());
//			
//			for (MaxPlayerByRoleDto result : maxPlayer) {
//				boolean flag = true;
//					if(flag) {
//						System.out.println(result.getPlayerName() +" from " + result.getLabel() + " Role : " + result.getPlayerRole() +" PRICE : " + result.getPlayerPrice());	
//						flag=false;
//						break;
//					}
//					else {
//						break;
//					}
//					
//			}
//
//			
//			System.out.println("7------------------MaxPlayerByRoleDto");
//			
			
//			List<PlayerRolewiseByTeamDto> rollWise = teamDAOimpl.getPlayerRolewiseByTeam("CSK", "Batsman");
//			
//			for (PlayerRolewiseByTeamDto result : rollWise) {
//				System.out.println("for " + result.getLabel() +" " +result.getPlayerRole() + " is " +result.getPlayerName() +" " + result.getPlayerPrice());
//			}
			
//			System.out.println("8------------------PlayerRolewiseByTeamDto");
//			
//			
//			List<TotalSpendingTeamwiseDto> totalSpent = teamDAOimpl.getTotalSpendingTeamwise();
//			
//			for (TotalSpendingTeamwiseDto result : totalSpent) {
//				System.out.println("Total spent for the team " + result.getLabel() + " is " +result.getTotalAmountSpent());
//			}
//			
//			System.out.println("9------------------TotalSpendingTeamwiseDto");
			
			
			
		};
	}

}
