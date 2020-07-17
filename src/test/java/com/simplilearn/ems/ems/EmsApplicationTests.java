package com.simplilearn.ems.ems;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import com.simplilearn.ems.ems.controller.EmployeeController;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment= WebEnvironment.RANDOM_PORT)
@DisplayName("Test - Main Application")
class EmsApplicationTests {
	
	@Autowired
	private EmployeeController empCtrl;	
	
	@LocalServerPort
	private int port;
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	@DisplayName("Test - Load Application Context")
	void contextLoads() {
		assertThat(empCtrl).isNotNull();
	}
	
	@Test
	@DisplayName("Test - Home Page Verification")
	public void testGreetingOnHomeController() {
		String homeUri = "http://localhost:"+port+"/api";
		ResponseEntity<String> result = this.restTemplate.getForEntity(homeUri, String.class);

		assertEquals("Hello, World", result.getBody());
		assertEquals(200, result.getStatusCodeValue());
	}
}
