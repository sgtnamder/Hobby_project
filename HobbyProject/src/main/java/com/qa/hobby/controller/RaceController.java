package com.qa.hobby.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.hobby.domain.Race;
import com.qa.hobby.dto.RaceDTO;
import com.qa.hobby.service.RaceService;

@RestController
@RequestMapping("/race")
public class RaceController {
	
	private RaceService service;
	
	@Autowired
	public RaceController(RaceService service) {
		super();
		this.service=service;
	}
	@RequestMapping("/add")
	public RaceDTO addRace(@RequestBody Race race) {
		return this.service.addRace(race);
	}

}
