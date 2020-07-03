package com.simplilearn.ems.ems.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EmployeeExceptionHandler {
	
	//
	@ExceptionHandler({ EmployeeNotFoundException.class})
	public ResponseEntity<Object> handleException(EmployeeNotFoundException exception){
		return new ResponseEntity<>("Employee Not Found",HttpStatus.NOT_FOUND);
	}
	
}
