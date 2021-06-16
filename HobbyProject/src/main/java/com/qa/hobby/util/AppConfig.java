package com.qa.hobby.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.qa.hobby.mapper.DriverMapper;
import com.qa.hobby.mapper.RaceMapper;

@Configuration
public class AppConfig {

	@Bean
	public DriverMapper getMapper() {
		return new DriverMapper();
		
	}
	@Bean
	public RaceMapper getRaceMapper() {
		return new RaceMapper(getMapper());
	}
}
