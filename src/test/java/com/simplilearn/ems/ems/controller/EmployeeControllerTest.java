package com.simplilearn.ems.ems.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Date;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.simplilearn.ems.ems.model.Department;
import com.simplilearn.ems.ems.model.Employee;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest(webEnvironment= WebEnvironment.RANDOM_PORT)
@DisplayName("Test - Employee Controller")
public class EmployeeControllerTest {
	
	@LocalServerPort
	int port;
	
	/**
	 * POST Employee
	 * @throws URISyntaxException 
	 */
	@Test()
	@DisplayName("Test - Add Employee Success")
	public void testAddEmployeeSuccess() throws URISyntaxException {
		// create URI
		final String baseUrl = "http://localhost:"+port+"/api/"+"employees/";
		URI uri = new URI(baseUrl);
		
		// create aemployee Object
		Employee emp = new Employee(102L,"Mike", "Smith", "mike.smith@gmail.com", 1000.37,  new Date(),
				new Department(2L, "Developement"));
		//Http Entity
		HttpEntity<Employee> request = new HttpEntity<>(emp);
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> result = restTemplate.postForEntity(uri, request,String.class);
		
		//verify success response
		assertEquals(200, result.getStatusCodeValue());
	}
	
	
	@Test
	@Disabled
	@DisplayName("Test - Add Employee Failure")
	public void testAddEmployeeFailure() throws URISyntaxException {
		// create URI
		final String baseUrl = "http://localhost:"+port+"/api/"+"employees/";
		URI uri = new URI(baseUrl);		
		Employee emp = null;
		//Http Entity  : Pass emp object as null
		HttpEntity<Employee> request = new HttpEntity<>(emp);
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> result = restTemplate.postForEntity(uri, request,String.class);
		
		//verify for invalid input response
		assertEquals(415, result.getStatusCodeValue());
	}
	
	@Test
	@DisplayName("Test - GetAll Employee Success")
	@Disabled
	public void testGetEmployeesSuccess() throws URISyntaxException {
		// create URI
		final String baseUrl = "http://localhost:"+port+"/api/"+"employees/";
		URI uri = new URI(baseUrl);		
	
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> result = restTemplate.getForEntity(uri,String.class);
		
		//verify for invalid input response
		assertEquals(200, result.getStatusCodeValue());
		assertEquals(false, result.getBody().isEmpty());
	}
}
