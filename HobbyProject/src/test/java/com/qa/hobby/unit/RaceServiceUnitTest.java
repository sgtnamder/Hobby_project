package com.qa.hobby.unit;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import com.qa.hobby.domain.Driver;
import com.qa.hobby.domain.Race;
import com.qa.hobby.repo.DriverRepo;
import com.qa.hobby.repo.RaceRepo;
import com.qa.hobby.service.DriverService;
import com.qa.hobby.service.RaceService;

@SpringBootTest
@ActiveProfiles("test")
public class RaceServiceUnitTest {
	
	@Autowired
	private RaceService service;
	private DriverService dservice;
	
	
	@MockBean
	private RaceRepo repo;
	private DriverRepo drepo;
	
	@Test
	void testAddRace(){
		//given
		Driver driver = new Driver("S.Perez","Redbull",25,11,"2:13:36:410",1);
		List<Driver> drivers = new ArrayList<>();
		drivers.add(driver);
		Race race = new Race("Azerbaijan","06,06,2021","13.00",drivers);
		
		//when
		Mockito.when(this.drepo.save(driver)).thenReturn(driver);
		Mockito.when(this.repo.save(race)).thenReturn(race);
		//then
		assertThat(this.service.addRace(race)).isEqualTo(race);
		
		Mockito.verify(this.repo,Mockito.times(1)).save(race);
	}
	@Test
	void testGetallRaces() {
		//given
		Race race = new Race("Azerbaijan","06,06,2021","13.00");
		//when
		Mockito.when(this.repo.save(race)).thenReturn(race);
		//when
		assertThat(this.service.getAllRaces()).isEqualTo(race);
		
		Mockito.verify(this.repo,Mockito.times(1)).save(race);
	}
	@Test
	void testUpdateRace() {
		//given
		Integer id = 1;
		Race race = new Race("Azerbaijan","06,06,2021","13.00");
		Race existing = new Race(id, null, null, null, null);
		//when
		Mockito.when(this.repo.findById(id)).thenReturn(Optional.of(existing));
		Mockito.when(this.repo.save(race)).thenReturn(race);
		//then
		assertThat(this.service.updateRace(id, race)).isEqualTo(race);
		
		Mockito.verify(this.repo,Mockito.times(1)).save(race);
		Mockito.verify(this.repo,Mockito.times(1)).findById(id);	
		
	}
	@Test
	void testDeleteRace() {
		//given
		Integer id = 1;
		boolean value = true;
		//when
		Mockito.when(this.repo.existsById(id)).thenReturn(!value);
		//then
		assertThat(this.service.deleteRace(id)).isEqualTo(value);
		
		Mockito.verify(this.repo,Mockito.times(1)).existsById(id);
	}
	
}