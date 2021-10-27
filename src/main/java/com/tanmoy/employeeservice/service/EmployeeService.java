package com.tanmoy.employeeservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tanmoy.employeeservice.domain.Employee;
import com.tanmoy.employeeservice.repository.EmployeeRepository;

@Service
public class EmployeeService {

	private EmployeeRepository empRepo;

	@Autowired
	public EmployeeService(EmployeeRepository empRepo) {
		this.empRepo = empRepo;
	}

	public Employee findEmployeeById(int id) {
		return empRepo.findById(id);
	}

}
