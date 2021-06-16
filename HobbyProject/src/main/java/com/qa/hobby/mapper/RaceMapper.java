package com.qa.hobby.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.qa.hobby.domain.Driver;
import com.qa.hobby.domain.Race;
import com.qa.hobby.dto.DriverDTO;
import com.qa.hobby.dto.RaceDTO;

public class RaceMapper {
	
	private DriverMapper driverMapper;
	
	public RaceMapper(DriverMapper driverMapper) {
		super();
		this.driverMapper = driverMapper;
	}
	
	public RaceDTO mapTo(Race race) {
		RaceDTO dto = new RaceDTO();
		dto.setId(race.getId());
		dto.setName(race.getName());
		dto.setDate(race.getDate());
		dto.setTime(race.getTime());
		List<DriverDTO> drivers = new ArrayList<>();
		
		for(Driver driver : race.getDrivers()) {
			drivers.add(this.driverMapper.mapTo(driver));
		}
		dto.setDrivers(drivers);
		return dto;
		
	}
	
}
