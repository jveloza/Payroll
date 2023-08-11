package com.payroll.app.service;

import java.util.List;
import java.util.Optional;

import com.payroll.app.entity.Employee;

public interface EmployeeDataService {

	List<Employee> getEmployeeList();
	
	Optional<Employee> getEmployeeDetail(Long id);
	
	Employee createEmployee(Employee employee);
	
	Employee updateEmployee(Employee employee, Long id);
	
}
