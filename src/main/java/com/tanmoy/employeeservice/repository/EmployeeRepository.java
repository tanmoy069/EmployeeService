package com.tanmoy.employeeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tanmoy.employeeservice.domain.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	Employee findById(int id);

}
