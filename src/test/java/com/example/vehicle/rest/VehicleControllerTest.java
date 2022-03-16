package com.example.vehicle.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import com.example.vehicle.domain.Vehicle;
import com.fasterxml.jackson.databind.ObjectMapper;



@SpringBootTest
@AutoConfigureMockMvc
@Sql(scripts = {"classpath:vehicle-schema.sql","classpath:vehicle-data.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test")
public class VehicleControllerTest {
	
	@Autowired
	public MockMvc mock;

	@Autowired
	private ObjectMapper map;
	
	@Test
	void testCreate() throws Exception {
		
		Vehicle create = new Vehicle("Car",4,"Blue");
	
		String createJSON =this.map.writeValueAsString(create);
	
		RequestBuilder mockRequest = post("/create").contentType(MediaType.APPLICATION_JSON).content(createJSON);
		
		Vehicle saved = new Vehicle(1,"Car", 4, "Blue");

		String savedJSON =this.map.writeValueAsString(saved);

		ResultMatcher matchStatus = status().isCreated();

		ResultMatcher matchBody = content().json(savedJSON);
		this.mock.perform(mockRequest).andExpect(matchStatus).andExpect(matchBody);		
	}
	@Test
	void testRemove() throws Exception {

		Long id = 1L;
		RequestBuilder request = delete("/remove/?id="+id);	
		ResultMatcher status = status().is(404);
		this.mock.perform(request).andExpect(status).andExpect(status);		
	}

	
}