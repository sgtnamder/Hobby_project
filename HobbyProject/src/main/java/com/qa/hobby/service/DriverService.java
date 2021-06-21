package com.qa.hobby.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.hobby.domain.Driver;
import com.qa.hobby.dto.DriverDTO;
import com.qa.hobby.mapper.DriverMapper;
import com.qa.hobby.repo.DriverRepo;

@Service
public class DriverService {
	
	@Autowired
	private DriverMapper mapper;

	private DriverRepo repo;

	public DriverService(DriverMapper mapper,DriverRepo repo) {
		super();
		this.repo = repo;
		this.mapper = mapper;
	}

	public DriverDTO addDriver(Driver driver) {
		this.repo.save(driver);
		return this.mapper.mapTo(driver);
	}

	public List<DriverDTO> getDrivers() {
		return this.repo.findAll().stream().map(driver -> this.mapper.mapTo(driver)).collect(Collectors.toList());
	}

	public DriverDTO updateDriver(Integer id, Driver driver) {
		Driver current = this.repo.findById(id).orElseThrow(() ->new EntityNotFoundException());
			current.setDriverNum(driver.getDriverNum());
			current.setId(id);
			current.setName(driver.getName());
			current.setPoints(driver.getPoints());
			current.setPosition(driver.getPosition());
			current.setTeamName(driver.getTeamName());
			current.setTime(driver.getTime());
		Driver updated = this.repo.save(current);
		return this.mapper.mapTo(updated);
	}
	public Boolean deleteDriver(Integer id) {
		this.repo.deleteById(id);
		return !this.repo.existsById(id);
	}
	
	

}
