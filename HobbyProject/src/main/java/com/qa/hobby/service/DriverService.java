package com.qa.hobby.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.qa.hobby.domain.Driver;
import com.qa.hobby.dto.DriverDTO;
import com.qa.hobby.mapper.DriverMapper;
import com.qa.hobby.repo.DriverRepo;

@Service
public class DriverService {

	private DriverMapper mapper;

	private DriverRepo repo;

	public DriverService() {
		super();
		this.repo = repo;
		this.mapper = mapper;
	}

	public DriverDTO addDriver(Driver driver) {
		this.repo.save(driver);
		return this.mapper.mapTo(driver);
	}

}
