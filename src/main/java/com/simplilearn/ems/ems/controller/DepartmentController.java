package com.simplilearn.ems.ems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simplilearn.ems.ems.model.Department;
import com.simplilearn.ems.ems.repository.DepartmentRepository;

@RestController
@RequestMapping("/api")
public class DepartmentController {

	@Autowired
	DepartmentRepository deptRepo;

	// add dept
	@PostMapping("/depts")
	public Department addDepartment(@RequestBody Department dept) {
		return deptRepo.save(dept);
	}

	// add dept
	@GetMapping("/dept")
	public List<Department> getAllDepartment() {
		return deptRepo.findAll();
	}
}
