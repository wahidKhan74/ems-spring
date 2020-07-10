package com.simplilearn.ems.ems.controller;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simplilearn.ems.ems.exception.EmployeeNotFoundException;
import com.simplilearn.ems.ems.model.Employee;
import com.simplilearn.ems.ems.repository.EmployeeRepository;

@RestController
@RequestMapping("/api")
public class EmployeeController {
	
	private static final Logger LOGGER = LogManager.getLogger(EmployeeController.class);
	
	@Autowired
	EmployeeRepository empRepo;

	// @Autowired annotation is used for automatic dependency injection

	// Get all Employee
	@GetMapping("/employees")
	public List<Employee> getAllEmployee() {
		List<Employee> employees =null;
		try {	
			LOGGER.info("Get : All Employee in EMS");
			employees= empRepo.findAll();
			
		} catch (Exception e) {
			LOGGER.error("Get : ALL Employee in EMS has error"+e);			
		}
		return employees;
	}

	// Create a new Employee
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee emp) {
		return empRepo.save(emp);
	}

	// Update a Employee
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee emp) {
		
		//	find operation
		Optional<Employee> opEmployee = empRepo.findById(emp.getId());
		
		// update operation
		Employee fetchedEmployee = opEmployee.get();
		fetchedEmployee.setFirstName(emp.getFirstName());
		fetchedEmployee.setLastName(emp.getLastName());
		fetchedEmployee.setSalary(emp.getSalary());
		
		return  empRepo.save(fetchedEmployee);
	}
	
	//Get One Employee
	@GetMapping("/employees/{id}")
	public Employee getOneEmployee(@PathVariable(value="id") Long empId) {
		
		return empRepo.findById(empId)
				.orElseThrow(()-> new EmployeeNotFoundException() );

	}
	
	//Delete Employee 
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<?> deleteOneEmployee(@PathVariable(value="id") Long empId) {
		
		 empRepo.deleteById(empId);
		return ResponseEntity.ok().build();
	}

}
