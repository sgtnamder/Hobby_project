package com.qa.hobby.integration;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.hobby.domain.Driver;
import com.qa.hobby.dto.DriverDTO;


@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT) // prevents port conflicts
@AutoConfigureMockMvc
@Sql(scripts = { "classpath:planner-schema.sql", "classpath:driver-data.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
public class DriverIntegrationTest {

	@Autowired
	private MockMvc mvc; // allows us to send mock requests

	@Autowired
	private ObjectMapper mapper;
	
	@Test
	void testDriveCreate() throws Exception {
	Driver testDriver = new Driver("S.Perez","Redbull",25,11,"2:13:36:410",1);
	String testDriverJson = this.mapper.writeValueAsString(testDriver);
	DriverDTO savedDriver = new DriverDTO("S.Perez","Redbull",25,11,"2:13:36:410",1);
	savedDriver.setId(2);
	String SavedDriverJson = this.mapper.writeValueAsString(savedDriver);
	
	RequestBuilder mockRequest = post("/driver/add").content(testDriverJson).contentType(MediaType.APPLICATION_JSON);
	ResultMatcher checkStatus = status().isOk();
	ResultMatcher checkbody = content().json(SavedDriverJson);
	
	this.mvc.perform(mockRequest).andExpect(checkStatus).andExpect(checkbody);
	}
	
	@Test
	void testupodatedriver() throws Exception{
		Integer id = 1;
		Driver testDriver = new Driver("L.Hamilton","Mercades",25,44,"2:13:36:410",1);
		String testDriverJson = this.mapper.writeValueAsString(testDriver);
		DriverDTO updatedDriver = new DriverDTO("L.Hamilton","Mercades",25,44,"2:13:36:410",1);
		updatedDriver.setId(id);
		String updatedDriverJson = this.mapper.writeValueAsString(updatedDriver);
		
		RequestBuilder mockRequest = put("/driver/update/"+id).content(testDriverJson).contentType(MediaType.APPLICATION_JSON);
		ResultMatcher checkStatus = status().isOk();
		ResultMatcher checkbody = content().json(updatedDriverJson);
		
		this.mvc.perform(mockRequest).andExpect(checkStatus).andExpect(checkbody);
	}
	
	@Test
	void testDelteteDriver() throws Exception{
		Integer id = 1;
		
		RequestBuilder mockRequest = delete("/driver/delete/"+id);
		ResultMatcher checkStatus = status().isOk();
		
		this.mvc.perform(mockRequest).andExpect(checkStatus);
		
		
		
	}
	
	@Test
	void getDriversTest() throws Exception{
		DriverDTO testDriver = new DriverDTO("S.Perez","Redbull",25,11,"2:13:36:410",1);
		testDriver.setId(1);
		List<DriverDTO> drivers = List.of(testDriver);
		String testDriverJson = this.mapper.writeValueAsString(drivers);
		
		this.mvc.perform(get("/driver/")).andExpect(status().isOk()).andExpect(content().json(testDriverJson));
		
	}
	
	
}

