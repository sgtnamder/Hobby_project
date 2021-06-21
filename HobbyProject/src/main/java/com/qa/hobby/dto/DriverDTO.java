package com.qa.hobby.dto;

public class DriverDTO {
	
	private Integer id;
	
	private String name;
	
	private String teamName;
	
	private Integer points;
	
	private Integer driverNum;
	
	private String time;
	
	private Integer position;

	public DriverDTO() {
		
	}

	public DriverDTO(String name, String teamName, Integer points, Integer driverNum, String time, Integer position) {
		super();
		this.name = name;
		this.teamName = teamName;
		this.points = points;
		this.driverNum = driverNum;
		this.time = time;
		this.position = position;
	}

	public DriverDTO(Integer id, String name, String teamName, Integer points, Integer driverNum, String time,
			Integer position) {
		super();
		this.id = id;
		this.name = name;
		this.teamName = teamName;
		this.points = points;
		this.driverNum = driverNum;
		this.time = time;
		this.position = position;
	}

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

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public Integer getPoints() {
		return points;
	}

	public void setPoints(Integer points) {
		this.points = points;
	}

	public Integer getDriverNum() {
		return driverNum;
	}

	public void setDriverNum(Integer driverNum) {
		this.driverNum = driverNum;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Integer getPosition() {
		return position;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}
	
	
	
	
}
