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
import com.qa.hobby.domain.Race;


@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT) // prevents port conflicts
@AutoConfigureMockMvc
@Sql(scripts = { "classpath:planner-schema.sql", "classpath:race-data.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
public class RaceIntergrationTest {

	@Autowired
	private MockMvc mvc; // allows us to send mock requests

	@Autowired
	private ObjectMapper mapper;
	
	@Test
	void testRaceCreate() throws Exception{
		Race testRace = new Race("Azerbaijan","06,06,2021","13.00");
		String testRaceJson = this.mapper.writeValueAsString(testRace);
		Race savedRace = new Race("Azerbaijan","06,06,2021","13.00");
		savedRace.setId(0);
		String savedRaceJson = this.mapper.writeValueAsString(savedRace);
		
		RequestBuilder mockRequest = post("/race/add").content(testRaceJson).contentType(MediaType.APPLICATION_JSON);
		ResultMatcher checkStatus = status().isOk();
		ResultMatcher checkbody = content().json(savedRaceJson);
		
		this.mvc.perform(mockRequest).andExpect(checkStatus).andExpect(checkbody);
	}
	
	@Test
	void testRaceUpdate() throws Exception{
		Integer id = 1;
		Race testRace = new Race("Azerbaijan","06,06,2021","13.00");
		String testRaceJson = this.mapper.writeValueAsString(testRace);
		Race updatedRace = new Race("Azerbaijan","06,06,2021","13.00");
		updatedRace.setId(id);
		String updatedRaceJson = this.mapper.writeValueAsString(updatedRace);
		
		RequestBuilder mockRequest = put("/race/update/"+id).content(testRaceJson).contentType(MediaType.APPLICATION_JSON);
		ResultMatcher checkStatus = status().isOk();
		ResultMatcher checkbody = content().json(updatedRaceJson);
		
		this.mvc.perform(mockRequest).andExpect(checkStatus).andExpect(checkbody);
		
	}
	@Test
	void testDelteteDriver() throws Exception{
		Integer id = 1;
		
		RequestBuilder mockRequest = delete("/race/delete/"+id);
		ResultMatcher checkStatus = status().isOk();
		
		this.mvc.perform(mockRequest).andExpect(checkStatus);
					
	}
	@Test
	void getDriversTest() throws Exception{
		Race testRace = new Race("Azerbaijan","06,06,2021","13.00");
		testRace.setId(1);
		List<Race> races = List.of(testRace);
		String testRaceJson = this.mapper.writeValueAsString(races);
		
		this.mvc.perform(get("/race/")).andExpect(status().isOk()).andExpect(content().json(testRaceJson));
		
	}
	
	
	
	
}
