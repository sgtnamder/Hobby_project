package com.qa.hobby.dto;

import java.util.List;

public class RaceDTO {
	private Integer id;

	private String name;

	private String date;

	private String time;

	private List<DriverDTO> drivers;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public List<DriverDTO> getDrivers() {
		return drivers;
	}

	public void setDrivers(List<DriverDTO> drivers) {
		this.drivers = drivers;
	}

}
