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
import com.qa.hobby.dto.DriverDTO;
import com.qa.hobby.repo.DriverRepo;
import com.qa.hobby.service.DriverService;



@SpringBootTest
@ActiveProfiles("test")
public class DriverServiceUnitTest {
	
	@Autowired
	private DriverService service;
	
	
	@MockBean
	private DriverRepo repo;
	
	@Test
	void testAddDriver(){
		//given
		Driver driver = new Driver("S.Perez","Redbull",25,11,"2:13:36:410",1);
		DriverDTO driverDTO = new DriverDTO("S.Perez","Redbull",25,11,"2:13:36:410",1);
		//when
		Mockito.when(this.repo.save(driver)).thenReturn(driver);
		//then
		assertThat(this.service.addDriver(driver)).usingRecursiveComparison().isEqualTo(driverDTO);
		
		
		Mockito.verify(this.repo,Mockito.times(1)).save(driver);
	}
	@Test
	void testGetallDrivers() {
		//given
		Driver driver = new Driver("S.Perez","Redbull",25,11,"2:13:36:410",1);
		List<Driver> drivers = new ArrayList<>();
		drivers.add(driver);
		DriverDTO driverDTO = new DriverDTO("S.Perez","Redbull",25,11,"2:13:36:410",1);
		List<DriverDTO> driversDTO = new ArrayList<>();
		driversDTO.add(driverDTO);
		//when
		Mockito.when(this.repo.findAll()).thenReturn(drivers);
		//then
		assertThat(this.service.getDrivers()).usingRecursiveComparison().isEqualTo(driversDTO);
		
		Mockito.verify(this.repo,Mockito.times(1)).findAll();
		
	}
	@Test
	void testUpdateDriver() {
		//given
		Integer id = 1;
		Driver driver = new Driver("S.Perez","Redbull",25,11,"2:13:36:410",1);
		Driver existing = new Driver(id, null, null, null, null, null, null);
		Driver updated = new Driver(id,"S.Perez","Redbull",25,11,"2:13:36:410",1);
		//when
		Mockito.when(this.repo.findById(id)).thenReturn(Optional.of(existing));
		Mockito.when(this.repo.save(updated)).thenReturn(updated);
		//then
		assertThat(this.service.updateDriver(id, driver)).usingRecursiveComparison().isEqualTo(updated);
		
		Mockito.verify(this.repo,Mockito.times(1)).save(updated);
		Mockito.verify(this.repo,Mockito.times(1)).findById(id);	
		
	}
	@Test
	void testDeleteDriver() {
		//given
		Integer id = 1;
		boolean value = true;
		//when
		Mockito.when(this.repo.existsById(id)).thenReturn(!value);
		//then
		assertThat(this.service.deleteDriver(id)).isEqualTo(value);
		
		Mockito.verify(this.repo,Mockito.times(1)).existsById(id);
	}
	
}
