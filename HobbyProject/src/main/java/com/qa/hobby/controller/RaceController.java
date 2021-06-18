package com.qa.hobby.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
		this.service = service;
	}

	@PostMapping("/add")
	public RaceDTO addRace(@RequestBody Race race) {
		return this.service.addRace(race);
	}

	@GetMapping("/")
	public List<RaceDTO> getAllRaces(){
		return this.service.getAllRaces();
	}

	@PutMapping("/update/{id}")
	public RaceDTO updateRace(@RequestBody Race race, @PathVariable Integer id) {
		return this.service.updateRace(id, race);
	}
	@DeleteMapping("/delete/{id}")
	public Boolean deleteRace(@PathVariable Integer id) {
		return this.service.deleteRace(id);
	}
}
