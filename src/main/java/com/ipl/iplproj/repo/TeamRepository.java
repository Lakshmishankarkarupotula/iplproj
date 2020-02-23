package com.ipl.iplproj.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ipl.iplproj.model.Team;

public interface TeamRepository extends MongoRepository<Team, String> {


}
