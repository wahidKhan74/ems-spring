package com.simplilearn.ems.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.simplilearn.ems.ems.model.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long>{

}
