package com.example.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Employee;
import com.example.model.request.EmployeeDto;
import com.example.service.EmployeeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class EmployeeController {
	
	private final EmployeeService employeeService;
	
	@PostMapping("/employee") // create
	public Employee save(@RequestBody EmployeeDto emp) {
		return employeeService.save(emp);
	}
	
	@GetMapping("/employee") // read
	public List<Employee> findAll() {
		return employeeService.findAll();
	}
	
}
