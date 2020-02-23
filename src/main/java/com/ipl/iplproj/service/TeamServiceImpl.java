package com.ipl.iplproj.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.ipl.iplproj.dao.TeamDAO;
import com.ipl.iplproj.dto.MaxPlayerByRoleDto;
import com.ipl.iplproj.dto.PlayerRolewiseByTeamDto;
import com.ipl.iplproj.dto.PlayersNameTeamWiseDto;
import com.ipl.iplproj.dto.RoleCountTeamWiseDto;
import com.ipl.iplproj.dto.RoleStatisticsTeamwiseDto;
import com.ipl.iplproj.dto.SortPlayerBySalaryDto;
import com.ipl.iplproj.dto.TeamDetailsDto;
import com.ipl.iplproj.dto.TeamLabelDto;
import com.ipl.iplproj.dto.TotalSpendingTeamwiseDto;

@Service
public class TeamServiceImpl implements TeamService {

	
	private TeamDAO teamDAO;
	private static final Logger LOG = LoggerFactory.getLogger(TeamServiceImpl.class);
	
	
	@Autowired
	public TeamServiceImpl(TeamDAO teamDAO) {
		
		this.teamDAO = teamDAO;
	}

	//"/labels"
	@Override
	public TeamLabelDto getTeamLabels() {
		TeamLabelDto teamLables = teamDAO.getTeamLabels();
		LOG.info("Total labels found :{}", teamLables.getLabels().size());
		return teamLables;
	}


	//"/{label}"
	@Override
	public List<PlayersNameTeamWiseDto> getPlayerNameTeamWise(String label) {
		Assert.notNull(label,"Please enter the correct team label name");
		List<PlayersNameTeamWiseDto> players = teamDAO.getPlayerNameTeamWise(label);
		LOG.info("Total players found for {} is : {}", label, players.size());
		return players;
			
		
	}


	//"/{label}/rolecount"
	@Override
	public List<RoleCountTeamWiseDto> getRoleCountTeamWise(String label) {
		Assert.notNull(label,"Please enter the correct team label name");
		List<RoleCountTeamWiseDto> players = teamDAO.getRoleCountTeamWise(label);
		LOG.info("Total players found for {} is : {}", label, players.size());
		return players;
	}

	//"/{label}/statistics"
	@Override
	public List<RoleStatisticsTeamwiseDto> getRoleStatisticsTeamwise(String label) {
		Assert.notNull(label,"Please enter the correct team label name");
		List<RoleStatisticsTeamwiseDto> players = teamDAO.getRoleStatisticsTeamwise(label);
		LOG.info("Total players found for {} is : {}", label, players.size());
		return players;
	}

	//"/{label}/sortBySalary"
	@Override
	public List<SortPlayerBySalaryDto> getPlayerBySalarySorted(String label) {
		Assert.notNull(label,"Please enter the correct team label name");
		List<SortPlayerBySalaryDto> players = teamDAO.getPlayerBySalarySorted(label);
		LOG.info("Total players found for {} is : {}", label, players.size());
		return players;
	}


	@Override
	public List<PlayerRolewiseByTeamDto> getPlayerRolewiseByTeam(String label, String playerRole) {
		Assert.notNull(label,"Please enter the correct team label name");
		Assert.notNull(playerRole,"Please enter the correct player Role");
		List<PlayerRolewiseByTeamDto> players = teamDAO.getPlayerRolewiseByTeam(label, playerRole);
		LOG.info("Total players found for {} is : {}", label, players.size());
		return players;
	}

	@Override
	public List<TeamDetailsDto> getTeamDetailsList() {
		List<TeamDetailsDto> teams = teamDAO.getTeamDetailsList();
		LOG.info("Fetching all team details : {}", teams);
		return teams;
	}

	@Override
	public List<MaxPlayerByRoleDto> getMaxPlayerByRole() {
		List<MaxPlayerByRoleDto> maxPlayer = teamDAO.getMaxPlayerByRole();
		LOG.info("Fetching maximum paid player by role : {}", maxPlayer);
		return maxPlayer;
	}

	@Override
	public List<TotalSpendingTeamwiseDto> getTotalSpendingTeamwise() {
		List<TotalSpendingTeamwiseDto> totalSpending = teamDAO.getTotalSpendingTeamwise();
		LOG.info("Total spending team wise : {}", totalSpending);
		return totalSpending;
	}


}
