package com.simplilearn.ems.ems.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HomeController {

	@GetMapping("")
	public String greetingServer() {
		return "Hello, PCF Auto deployment with jekins";
	}
	
}
