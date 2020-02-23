package com.ipl.iplproj.dao.test;


import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;

import com.ipl.iplproj.SeedData;
import com.ipl.iplproj.dao.*;
import com.ipl.iplproj.dto.*;

import com.ipl.iplproj.model.Team;
import com.ipl.iplproj.repo.TeamRepository;

@SpringBootTest
public class TeamDaoTest {


	@Autowired
	private TeamDAO teamDAO;
	@Autowired
	private TeamRepository teamRepository;
	@Autowired
	private SeedData seedData;
	@Mock
	MongoOperations mongoOperations;

	@BeforeEach
	public void init() throws IOException {
		teamRepository.deleteAll();
		List<Team> teams = seedData.loadDataFromFile();
		System.out.println("Total team size:"+teams.size());
		teamRepository.saveAll(teams);
	}

	@AfterEach
	public void destory() {
		 
	}
	
	@Test
	public void sampleTest() {
		assertEquals(2, 2);
	}

	@Test
	public void teamLabels() {
		List<Team> list = teamRepository.findAll();
		System.out.println("Size of teams:" + list.size());
		TeamLabelDto lables = teamDAO.getTeamLabels();
		assertEquals(2, lables.getLabels().size());
	}

	@Test
	public void roleCountWiseByTeam() {
		System.out.println(teamRepository.count()+ " Total Teams");
		teamRepository.findAll().stream().forEach(t->{
			System.out.println(t.getTeam());
		});
		List<RoleCountTeamWiseDto> result = teamDAO.getRoleCountTeamWise("CSK");
		System.out.println(result + " "+result.size());
	    List<String> roleList = seedData.getRoleNames();
		Assertions.assertThat(result).isNotEmpty().hasSize(4);
		List<String> roles = result.stream().map(t -> t.getPlayersRole()).collect(Collectors.toList());
		Assertions.assertThat(roles).hasSize(roleList.size()).containsAll(roleList);
	}

//	@Test
//	public void roleCountWiseByTeam() {
////		System.out.println("=========================");
////		List<RoleCountTeamWiseDto> result = teamDAO.getRoleCountTeamWise("CSK");
////	    List<String> roleList = seedData.getRoleNames();
////		System.out.println("result is "+roleList);
////		List<String> roles = result.stream().map(t -> t.getPlayersRole()).collect(Collectors.toList());
////		System.out.println(roles);
//////		Assertions.assertThat(roles).hasSize(roleList.size()).containsAll(roleList);
//		RoleCountTeamWiseDto roleCount = RoleCountTeamWiseDto.builder().build();
//		List<RoleCountTeamWiseDto> expected = Collections.singletonList(roleCount);
//		Document mongoDocument = new Document();
//		AggregationResults<RoleCountTeamWiseDto> aggr = new AggregationResults<RoleCountTeamWiseDto>(expected,mongoDocument);
//		when(mongoOperations.aggregate(Mockito.any(),Mockito.eq("someCollection"),Mockito.eq(RoleCountTeamWiseDto.class))).thenReturn(aggr);
//		
//		List<RoleCountTeamWiseDto> actual = teamDAO.getRoleCountTeamWise("CSK");
//		
//		Assertions.assertThat(expected).isEqualTo(actual);
//	}
	
//	
//	@Test
//	public void teamLabelTest() {
//			
//		List<Team> list = teamRepository.findAll();
//		System.out.println("Size of teams:" + list.size());
//		List<TeamLabelDto> lables = teamDAO.getTeamLabels();
//		assertEquals(2, lables.size());
//		
//	}
////
//	@Test
//	public void playerNameTeamWiseTest(String label) {
//		List<Team> list = teamRepository.findAll();
//		System.out.println("Size of teams:" + list.size());
//		List<PlayersNameTeamWiseDto> result = teamDAO.getPlayerNameTeamWise("CSK");
//		assertEquals(4, result.size());
//		
//	}
////	
////	
//	@Test
//	public void teamDetailsTest() {
//		
//		List<TeamDetailsDto> teamDetails = teamDAO.getTeamDetailsList();
//		assertEquals(2, teamDetails.size());
//	}
//////	
////	@Test
////	public void roleCountTeamWiseTest() {
////		
////		List<RoleCountTeamWiseDto> list = teamDAO.getRoleCountTeamWise("CSK");
////		assertEquals(4, list.size());
////	}
//	
//	@Test
//	public void roleStatisticsTeamwiseTest() {
//		
//		List<RoleStatisticsTeamwiseDto> list = teamDAO.getRoleStatisticsTeamwise("CSK");
//		assertEquals(4, list.size());
//	}
//	
//	@Test
//	public void sortPlayerBySalaryTest() {
//		
//		List<SortPlayerBySalaryDto> list = teamDAO.getPlayerBySalarySorted("CSK");
//		assertEquals(4, list.size());
//	}
////	
//	@Test
//	public void maxPlayerByRoleTest() {
//		
//		List<MaxPlayerByRoleDto> list = teamDAO.getMaxPlayerByRole();
//		assertThat(list).isNotEmpty();
//		assertThat(list).contains();
//	}
////	
//	@Test
//	public void playerRolewiseByTeamTest() {
//		List<Team> list = teamRepository.findAll();
//		System.out.println("Size of teams:" + list.size());
//		List<PlayerRolewiseByTeamDto> result = teamDAO.getPlayerRolewiseByTeam("CSK", "Wicket Keeper");
//		System.out.println("player role wise"+result.toArray());
//		assertEquals(1, result.size());
//	}
//	
	@Test
	public void totalSpendingTeamwiseTest() {
		
		List<TotalSpendingTeamwiseDto> list = teamDAO.getTotalSpendingTeamwise();
		System.out.println("===============" + list);
		assertThat(list).isNotEmpty();
		assertThat(list).contains(new TotalSpendingTeamwiseDto("MI",830500000));
	}
}
