package com.qa.hobby.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.qa.hobby.domain.Race;
import com.qa.hobby.dto.RaceDTO;
import com.qa.hobby.mapper.RaceMapper;
import com.qa.hobby.repo.RaceRepo;

@Service
public class RaceService {

	private RaceMapper mapper;

	private RaceRepo repo;

	public RaceService(RaceRepo repo, RaceMapper mapper) {
		super();
		this.repo=repo;
		this.mapper=mapper;
	}
	
	public RaceDTO addRace(Race race) {
		this.repo.save(race);
		return this.mapper.mapTo(race);
	}
	
	public List<RaceDTO> getAllRaces(){
		return this.repo.findAll().stream().map(race -> this.mapper.mapTo(race)).collect(Collectors.toList());
	}

}
