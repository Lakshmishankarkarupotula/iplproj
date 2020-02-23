package com.ipl.iplproj.service;

import java.util.List;

import com.ipl.iplproj.dto.MaxPlayerByRoleDto;
import com.ipl.iplproj.dto.PlayerRolewiseByTeamDto;
import com.ipl.iplproj.dto.PlayersNameTeamWiseDto;
import com.ipl.iplproj.dto.RoleCountTeamWiseDto;
import com.ipl.iplproj.dto.RoleStatisticsTeamwiseDto;
import com.ipl.iplproj.dto.SortPlayerBySalaryDto;
import com.ipl.iplproj.dto.TeamDetailsDto;
import com.ipl.iplproj.dto.TeamLabelDto;
import com.ipl.iplproj.dto.TotalSpendingTeamwiseDto;

public interface TeamService {


	public TeamLabelDto getTeamLabels();
	
	public List<PlayersNameTeamWiseDto> getPlayerNameTeamWise(String label);
	
	public List<TeamDetailsDto> getTeamDetailsList();
	
	public List<RoleCountTeamWiseDto> getRoleCountTeamWise(String label);
	
	public List<RoleStatisticsTeamwiseDto> getRoleStatisticsTeamwise(String label);
	
	public List<SortPlayerBySalaryDto> getPlayerBySalarySorted(String label);
	
	public List<MaxPlayerByRoleDto> getMaxPlayerByRole();
	
	public List<PlayerRolewiseByTeamDto> getPlayerRolewiseByTeam(String label, String playerRole);
	
	public List<TotalSpendingTeamwiseDto> getTotalSpendingTeamwise();
}
