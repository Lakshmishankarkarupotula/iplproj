package com.ipl.iplproj.api;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.ipl.iplproj.dto.TeamLabelDto;
import com.ipl.iplproj.exception.MyBadRequestException;
import com.ipl.iplproj.service.TeamService;
import com.ipl.iplproj.dto.*;

@RestController
@RequestMapping("/iplproj/team/")
public class TeamDAOController{

	@Autowired
	private TeamService teamDAOService;

	@GetMapping("labels")
	public TeamLabelDto teamLabels() {
		return teamDAOService.getTeamLabels();
	}
	
	@GetMapping("{label}")
	public List<PlayersNameTeamWiseDto> getPlayersByTeam(@PathVariable("label") String label) {
			List<PlayersNameTeamWiseDto> players = teamDAOService.getPlayerNameTeamWise(label);
			if(players.size()==0) {
				throw new MyBadRequestException();
			}
			else {
				return players;
			}
		
	}	
	
	@GetMapping("{label}/rolecount")
	public List<RoleCountTeamWiseDto> getRoleCountTeamWise(@PathVariable("label") String label) {
		List<RoleCountTeamWiseDto> players = teamDAOService.getRoleCountTeamWise(label);
		if(players.size()==0) {
			throw new MyBadRequestException();
		}
		else {
			return players;
		}
	}	
	
	@GetMapping("{label}/statistics")
	public List<RoleStatisticsTeamwiseDto> getRoleStatisticsTeamwise(@PathVariable("label") String label) {
		List<RoleStatisticsTeamwiseDto> players = teamDAOService.getRoleStatisticsTeamwise(label);
		if(players.size()==0) {
			throw new MyBadRequestException();
		}
		else {
			return players;
		}
	}

	@GetMapping("{label}/sortbysalary")
	public List<SortPlayerBySalaryDto> getSortPlayerBySalary(@PathVariable("label") String label) {

		List<SortPlayerBySalaryDto> players = teamDAOService.getPlayerBySalarySorted(label);
		if(players.size()==0) {
			throw new MyBadRequestException();
		}
		else {
			return players;
		}
		
	}
	

	@GetMapping("{label}/{playerrole}")
	public List<PlayerRolewiseByTeamDto> getPlayerRolewiseByTeam(@PathVariable("label") String label, @PathVariable("playerrole") String playerRole) {
	
		List<PlayerRolewiseByTeamDto> players = teamDAOService.getPlayerRolewiseByTeam(label, playerRole);
		if(players.size()==0) {
			throw new MyBadRequestException();
		}
		else {
			return players;
		}
	}
	

	@GetMapping("teams")
	public List<TeamDetailsDto> getTeamDetailsList() {

		List<TeamDetailsDto> teams = teamDAOService.getTeamDetailsList();
		if(teams.size()==0) {
			throw new MyBadRequestException();
		}
		else {
			return teams;
		}
	}
	

	@GetMapping("biddingstatistics")
	public List<MaxPlayerByRoleDto> getMaxPlayerByRole() {

		List<MaxPlayerByRoleDto> teams = teamDAOService.getMaxPlayerByRole();
		if(teams.size()==0) {
			throw new MyBadRequestException();
		}
		else {
			return teams;
		}
	}
	


	@GetMapping("totalspending")
	public List<TotalSpendingTeamwiseDto> getTotalSpendingTeamwise() {

		List<TotalSpendingTeamwiseDto> totalSpending = teamDAOService.getTotalSpendingTeamwise();
		if(totalSpending.size()==0) {
			throw new MyBadRequestException();
		}
		else {
			return totalSpending;
		}	
	
	}
	
}