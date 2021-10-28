package com.tanmoy.employeeservice.service;

import java.util.List;

import javax.validation.Valid;

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
	
	public Employee findEmployeeByCode(String code) {
		return empRepo.findByCode(code);
	}
	
	public List<Employee> findAll() {
		return empRepo.findAll();
	}

	public boolean saveEmployee(@Valid Employee emp) {
		try {
			if (findEmployeeById(emp.getId()) == null) {
				empRepo.save(emp);
				return true;
			}
			return false;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public boolean updateEmployee(@Valid Employee emp) {
		try {
			if (findEmployeeById(emp.getId()) != null) {
				empRepo.save(emp);
				return true;
			}
			return false;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

}
