package com.tanmoy.employeeservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tanmoy.employeeservice.domain.Employee;
import com.tanmoy.employeeservice.model.EmployeeList;
import com.tanmoy.employeeservice.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	private EmployeeService empService;

	@Autowired
	public EmployeeController(EmployeeService empService) {
		this.empService = empService;
	}

	@GetMapping("/findby")
	public Employee findEmployeeBy(@RequestParam(name = "id", required = false) Integer id,
			@RequestParam(name = "code", required = false) String code) {
		if (id != null)	return empService.findEmployeeById(id);
		if (code != null) return empService.findEmployeeByCode(code);
		return null;
	}
	
	@GetMapping("/findall")
	public EmployeeList findAllEmployee() {
		return new EmployeeList(empService.findAll());
	}
	
	@PostMapping("/save")
	public boolean saveEmployee(@RequestBody Employee employee) {
		return empService.saveEmployee(employee);
	}
	
	@PostMapping("/update")
	public boolean updateEmployee(@RequestBody Employee employee) {
		return empService.updateEmployee(employee);
	}

}
