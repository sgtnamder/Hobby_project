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
@Sql(scripts = { "classpath:planner-schema.sql", "classpath:race-data.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
public class RaceIntergrationTest {

	@Autowired
	private MockMvc mvc; // allows us to send mock requests

	@Autowired
	private ObjectMapper mapper;
	
	@Test
	
	
	
	
}
