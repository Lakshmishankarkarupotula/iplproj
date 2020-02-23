package com.ipl.iplproj.dao.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ipl.iplproj.dto.*;
import com.ipl.iplproj.service.TeamService;

@SpringBootTest
public class TeamServiceTest {
	
	@Autowired
	private TeamService teamService;

	

	@Test
	public void getTeamLabels() {

		TeamLabelDto teamLables = teamService.getTeamLabels();
		assertEquals(8, teamLables.getLabels().size());
	}
	
	public void getPlayerNameTeamWise(String label){
		 

		TeamLabelDto teamLables = teamService.getTeamLabels();
		assertEquals(8, teamLables.getLabels().size());
		
	}
	
	public void getTeamDetailsList(){
		 
		
		
	}
	
	public void getRoleCountTeamWise(String label){
		 
		
	}
	
	public void getRoleStatisticsTeamwise(String label){
		 
		
	}
	
	public void getPlayerBySalarySorted(String label){
		 
		
	}
	
	public void getMaxPlayerByRole(){
		 
		
		
	}
	
	public void getPlayerRolewiseByTeam(String label, String playerRole){
		 
		
	}
	
	public void getTotalSpendingTeamwise(){
		 
		
		
	}
}
