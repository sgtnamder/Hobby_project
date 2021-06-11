package com.qa.hobby.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.hobby.domain.Driver;
import com.qa.hobby.dto.DriverDTO;
import com.qa.hobby.service.DriverService;

@RestController
@RequestMapping("/drivers")
public class DriverController {

	private DriverService service;
	
	@Autowired
	public DriverController(DriverService service) {
	super();
	this.service = service;
	}
	
	@RequestMapping("/add")
	public DriverDTO addDriver(@RequestBody Driver driver) {
		return this.service.addDriver(driver);
	}
	
	@RequestMapping("/")
	public List<DriverDTO> getAllDrivers() {
		return this.service.getAllDrivers();
	}
	
	
}
