package com.simplilearn.ems.ems;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmsApplication {
	
	private static final Logger LOGGER = LogManager.getLogger(EmsApplication.class);
			
	public static void main(String[] args) {
		LOGGER.info("Starting Spring boot application with logs...");
		SpringApplication.run(EmsApplication.class, args);
		
	}

}
