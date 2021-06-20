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
@RequestMapping("/race")// creates an address for modifying races
public class RaceController {

	private RaceService service;

	@Autowired // create the a new instance if service
	public RaceController(RaceService service) {
		super();
		this.service = service;
	}

	@PostMapping("/add") // creates and address to add a races
	public RaceDTO addRace(@RequestBody Race race) {
		return this.service.addRace(race);
	}

	@GetMapping("/")// creates and address to get all races
	public List<RaceDTO> getAllRaces(){
		return this.service.getAllRaces();
	}

	@PutMapping("/update/{id}")// creates and address to update races by id
	public RaceDTO updateRace(@RequestBody Race race, @PathVariable Integer id) {
		return this.service.updateRace(id, race);
	}
	@DeleteMapping("/delete/{id}")// creates and address to delete races by id
	public Boolean deleteRace(@PathVariable Integer id) {
		return this.service.deleteRace(id);
	}
}
