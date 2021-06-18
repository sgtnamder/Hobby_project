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

import com.qa.hobby.domain.Driver;
import com.qa.hobby.dto.DriverDTO;
import com.qa.hobby.service.DriverService;

@RestController
@RequestMapping("/driver")
public class DriverController {

	private DriverService service;

	@Autowired
	public DriverController(DriverService service) {
		super();
		this.service = service;
	}

	@PostMapping("/add")
	public DriverDTO addDriver(@RequestBody Driver driver) {
		return this.service.addDriver(driver);
	}

	@GetMapping("/")
	public List<DriverDTO> getAllDrivers() {
		return this.service.getDrivers();
	}

	@PutMapping("/update/{id}")
	public DriverDTO updateDriver(@RequestBody Driver driver, @PathVariable("id") Integer id ){
		return this.service.updateDriver(id, driver);
	}
	@DeleteMapping("/delete/{id}")
	public Boolean deleteDriver(@PathVariable Integer id) {
		return this.service.deleteDriver(id);
	}

}
