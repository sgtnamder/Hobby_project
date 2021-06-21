package com.qa.hobby.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Race {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String name;

	private String date;

	private String time;
	
	@OneToMany(mappedBy = "race")
	private List<Driver> drivers;

	public Race() {
		super();
		this.id = 0;
		this.name = "empty";
		this.date = "empty";
		this.time = "empty";
		this.drivers = new ArrayList<>();
	}

	public Race(Integer id, String name, String date, String time, List<Driver> drivers) {
		this();
		this.id = id;
		this.name = name;
		this.date = date;
		this.time = time;
		this.drivers = drivers;
	}

	public Race(String name, String date, String time, List<Driver> drivers) {
		this();
		this.name = name;
		this.date = date;
		this.time = time;
		this.drivers = drivers;
	}
	
	public Race(Integer id, String name, String date, String time) {
		this();
		this.id = id;
		this.name = name;
		this.date = date;
		this.time = time;
		
	}

	public Race(String name, String date, String time) {
		this();
		this.name = name;
		this.date = date;
		this.time = time;
	}

	@Override
	public String toString() {
		return "Race [id=" + id + ", name=" + name + ", date=" + date + ", time=" + time + ", drivers=" + drivers + "]";
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

	public List<Driver> getDrivers() {
		return drivers;
	}

	public void setDrivers(List<Driver> drivers) {
		this.drivers = drivers;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((drivers == null) ? 0 : drivers.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((time == null) ? 0 : time.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Race other = (Race) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (drivers == null) {
			if (other.drivers != null)
				return false;
		} else if (!drivers.equals(other.drivers))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (time == null) {
			if (other.time != null)
				return false;
		} else if (!time.equals(other.time))
			return false;
		return true;
	}

}
