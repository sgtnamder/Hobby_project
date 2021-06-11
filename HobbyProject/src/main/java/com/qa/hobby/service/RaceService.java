package com.qa.hobby.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

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
	public RaceDTO updateRace(Integer id, Race race) {
		Race current = this.repo.findById(id).orElseThrow(() ->new EntityNotFoundException());
			current.setName(race.getName());
			current.setDate(race.getDate());
			current.setTime(race.getTime());
		Race updated = this.repo.save(current);
		return this.mapper.mapTo(updated);	
	}
	
}
