package com.qa.hobby.mapper;

import com.qa.hobby.domain.Driver;
import com.qa.hobby.dto.DriverDTO;

public class DriverMapper {
	
	
	public DriverMapper(){
	}
	
	// maps drivers to a dto to send back to the front-end
	public DriverDTO mapTo(Driver driver) {
		DriverDTO dto = new DriverDTO();
		
		dto.setDriverNum(driver.getDriverNum());
		dto.setId(driver.getId());
		dto.setName(driver.getName());
		dto.setPoints(driver.getPoints());
		dto.setPosition(driver.getPosition());
		dto.setTeamName(driver.getTeamName());
		dto.setTime(driver.getTime());
		
		return dto; 
		
	}

}
