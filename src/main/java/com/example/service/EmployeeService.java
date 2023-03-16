package com.example.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.example.model.Employee;
import com.example.model.request.EmployeeDto;
import com.example.repository.EmployeeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeService {
	private final EmployeeRepository employeeRepository;

	public Employee save(EmployeeDto emp) {
		Employee emptemp = new Employee();
		BeanUtils.copyProperties(emp, emptemp);
		
		Employee employee = employeeRepository.save(emptemp);
		return employee;
	}

	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

	public Employee update(Employee emp) {
		Employee empTemp = employeeRepository.findById(emp.getId()).get(); // 원래 자료 

		// 입력할 자료
		empTemp.setFirstName(emp.getFirstName());
		empTemp.setLastName(emp.getLastName());
		empTemp.setEmailId(emp.getEmailId());
		
		return employeeRepository.save(empTemp);
	}

	public Employee delete(Long id) {
		Employee emp = employeeRepository.findById(id).get();
		employeeRepository.deleteById(id);
		return emp;
	}
	
}
