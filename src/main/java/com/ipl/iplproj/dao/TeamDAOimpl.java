package com.ipl.iplproj.dao;

import java.util.Arrays;
import java.util.List;

import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.MongoOperations;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.*;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationExpression;
import org.springframework.data.mongodb.core.aggregation.AggregationOperationContext;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Repository;
import com.ipl.iplproj.dto.PlayersNameTeamWiseDto;
import com.ipl.iplproj.dto.RoleCountTeamWiseDto;
import com.ipl.iplproj.dto.TeamDetailsDto;
import com.ipl.iplproj.dto.TeamLabelDto;
import com.ipl.iplproj.dto.MaxPlayerByRoleDto;
import com.ipl.iplproj.dto.PlayerRolewiseByTeamDto;
import com.ipl.iplproj.dto.RoleStatisticsTeamwiseDto;
import com.ipl.iplproj.dto.SortPlayerBySalaryDto;
import com.ipl.iplproj.dto.TotalSpendingTeamwiseDto;
//import com.ipl.iplproj.repo.TeamRepository;


@Repository("mongoArraylist")
public class TeamDAOimpl implements TeamDAO {

	
	//private TeamRepository teamRepository; 
	private MongoOperations mongoOperations;
	private static final Logger LOG = LoggerFactory.getLogger(TeamDAOimpl.class);

		
	@Autowired
	public TeamDAOimpl(MongoOperations mongoOperations) {
	  
		this.mongoOperations = mongoOperations;
	
	}
	
	@Override
	public TeamLabelDto getTeamLabels() {

		Aggregation aggr = Aggregation.newAggregation(
				group().addToSet("label").as("label"),
				project().and("label").as("labels").andExclude("_id")
									
		);
		AggregationResults<TeamLabelDto> aggrResult = mongoOperations.aggregate(aggr, "team", TeamLabelDto.class);
		TeamLabelDto result = aggrResult.getUniqueMappedResult();
		
		return result;
	}

	@Override
	public List<PlayersNameTeamWiseDto> getPlayerNameTeamWise(String label) {
		Aggregation aggr = Aggregation.newAggregation(
				unwind("players"),
				match(Criteria.where("label").is(label)),
				project().and("players.player").as("playerName")
				.and("players.role").as("playerRole")
				.and("players.price").as("playerPrice")
				.and("label").as("label")
				.andExclude("_id")
									
		);
		AggregationResults<PlayersNameTeamWiseDto> aggrResult = mongoOperations.aggregate(aggr, "team", PlayersNameTeamWiseDto.class);
		List<PlayersNameTeamWiseDto> result = aggrResult.getMappedResults();
		
		return result;
	}

	@Override
	public List<TeamDetailsDto> getTeamDetailsList() {
		Aggregation aggr = Aggregation.newAggregation(
				project().and("label").as("label")
				.and("team").as("team")
				.and("city").as("city")
				.and("coach").as("coach")
				.and("home").as("home")
				.andExclude("_id")
									
		);
		AggregationResults<TeamDetailsDto> aggrResult = mongoOperations.aggregate(aggr, "team", TeamDetailsDto.class);
		List<TeamDetailsDto> result = aggrResult.getMappedResults();
		
		
		return result;
	}

	@Override
	public List<RoleCountTeamWiseDto> getRoleCountTeamWise(String label) {

		Aggregation aggr = Aggregation.newAggregation(
							unwind("players"),
							match(Criteria.where("label").is(label)),
							group("players.role").count().as("count"),
							project().and("_id").as("playersRole").and("count").as("playersCount").andExclude("_id")
												
				);
		AggregationResults<RoleCountTeamWiseDto> aggrResult = mongoOperations.aggregate(aggr, "team", RoleCountTeamWiseDto.class);
		
		List<RoleCountTeamWiseDto> result = aggrResult.getMappedResults();
		return result;
	}

	@Override
	public List<RoleStatisticsTeamwiseDto> getRoleStatisticsTeamwise(String label) {
		
		Aggregation aggr = Aggregation.newAggregation(
				match(Criteria.where("label").is(label)),
				unwind("players"),
				group("players.role").sum("players.price").as("totalAmount"),
				project().and("_id").as("playersRole").and("totalAmount").as("totalAmountSpent").andExclude("_id")
									
		);	
		AggregationResults<RoleStatisticsTeamwiseDto> aggrResult = mongoOperations.aggregate(aggr, "team", RoleStatisticsTeamwiseDto.class);
		List<RoleStatisticsTeamwiseDto> result = aggrResult.getMappedResults();
		return result;
	}

	@Override
	public List<SortPlayerBySalaryDto> getPlayerBySalarySorted(String label) {
		
		Aggregation aggr = Aggregation.newAggregation(
				match(Criteria.where("label").is(label)),
				unwind("players"),
				group("players.role","players.player","players.price","label"),
				project().
					and("_id.role").as("playerRole").
					and("_id.price").as("playerPrice").
					and("_id.player").as("playerName").
					and("_id.label").as("label").andExclude("_id"),
					sort(Direction.DESC,"playerPrice") 
									
		);	
		AggregationResults<SortPlayerBySalaryDto> aggrResult = mongoOperations.aggregate(aggr, "team", SortPlayerBySalaryDto.class);
		List<SortPlayerBySalaryDto> result = aggrResult.getMappedResults();
		return result;
	}

	@Override
	public List<MaxPlayerByRoleDto> getMaxPlayerByRole() {
	
		Document obj = new Document();
		obj.put("label", "$label");
		obj.put("name", "$players.player");
		obj.put("price", "$players.price");
		obj.put("role", "$players.role");
		
		Aggregation aggr = newAggregation(
				unwind("players"),
				group("players.role").max("players.price").as("maxprice").push(obj).as("players"),
				
				project().and("_id").as("role").and("maxprice").as("amount")
						.and(new AggregationExpression() {
							@Override
							public Document toDocument(AggregationOperationContext aggregationOperationContext) {
								Document filterExpression = new Document();
								filterExpression.put("input", "$players");
								filterExpression.put("as", "players");
								filterExpression.put("cond",
										new Document("$eq", Arrays.<Object>asList("$$players.price", "$maxprice")));
								return new Document("$filter", filterExpression);
							}
						}).as("players"));

		System.out.println(aggr);
		LOG.info("Generated query is {}",aggr);
		AggregationResults<MaxPlayerByRoleDto> aggrResult = mongoOperations.aggregate(aggr, "team", MaxPlayerByRoleDto.class);
		List<MaxPlayerByRoleDto> result = aggrResult.getMappedResults();
		return result;
	}

	@Override
	public List<PlayerRolewiseByTeamDto> getPlayerRolewiseByTeam(String label ,String playerRole) {
		
		Aggregation aggr = newAggregation(
						match(Criteria.where("label").is(label)),
						unwind("players"),
						project().andExclude("_id").and("label").as("label").and("players.player").as("playerName")
								.and("players.price").as("playerPrice").and("players.role").as("playerRole"),
						match(Criteria.where("playerRole").is(playerRole)));
				AggregationResults<PlayerRolewiseByTeamDto> res = mongoOperations.aggregate(aggr, "team", PlayerRolewiseByTeamDto.class);
				List<PlayerRolewiseByTeamDto> playersDetails = res.getMappedResults();
				return playersDetails;
													
				
	}

	@Override
	public List<TotalSpendingTeamwiseDto> getTotalSpendingTeamwise() {
		
		Aggregation aggr = Aggregation.newAggregation(
				unwind("players"),
				group("label").sum("players.price").as("totalSpent"),
				project().and("_id").as("label").and("totalSpent").as("totalAmountSpent").andExclude("_id")
									
		);	
		AggregationResults<TotalSpendingTeamwiseDto> aggrResult = mongoOperations.aggregate(aggr, "team", TotalSpendingTeamwiseDto.class);
		List<TotalSpendingTeamwiseDto> result = aggrResult.getMappedResults();
		return result;
	}





}

