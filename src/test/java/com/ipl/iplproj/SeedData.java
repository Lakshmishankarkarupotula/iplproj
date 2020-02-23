package com.ipl.iplproj;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ipl.iplproj.model.Team;


@Component
public class SeedData {

	private List<Team> teams;

	public List<Team> loadDataFromFile() throws IOException {

		if (teams == null) {
			teams = new ArrayList<Team>();
			ClassLoader classLoader = getClass().getClassLoader();
			File file = new File(classLoader.getResource("ipldumb.json").getFile());
			ObjectMapper objectMapper = new ObjectMapper();
			Team[] retObject = objectMapper.readValue(new FileInputStream(file.getPath()), Team[].class);
			for (Team team : retObject) {
				teams.add(team);
				System.out.println(team);
			}
		}
		return teams;
	}

	public List<String> getRoleNames() {
		List<String> roleList = Arrays.asList("Batsman,Bowler,All-Rounder,Wicket Keeper".split(","));
		return roleList;
	}
}