package com.payroll.app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payroll.app.entity.Employee;
import com.payroll.app.repository.EmployeeJPARepository;
import com.payroll.app.service.EmployeeDataService;

@Service
public class EmployeeDataServiceImpl implements EmployeeDataService{

	@Autowired
	private EmployeeJPARepository employeeJPARepository;
	
	@Override
	public List<Employee> getEmployeeList() {
		return employeeJPARepository.findAll();
	}

	@Override
	public Optional<Employee> getEmployeeDetail(Long id) {
		return employeeJPARepository.findById(id);
	}

	@Override
	public Employee createEmployee(Employee employee) {
		return employeeJPARepository.save(employee);
	}

	@Override
	public Employee updateEmployee(Employee employee, Long id) {
		var OEmployee = employeeJPARepository.findById(id);
		if(OEmployee.isPresent()) {
			OEmployee.get().setFirstName(employee.getFirstName());
			OEmployee.get().setMiddleName(employee.getMiddleName());
			OEmployee.get().setLastname(employee.getLastname());
			OEmployee.get().setAddress(employee.getAddress());
			OEmployee.get().setDateBirth(employee.getDateBirth());
			OEmployee.get().setLocationCity(employee.getLocationCity());
			OEmployee.get().setTelephone(employee.getTelephone());
			return employeeJPARepository.save(OEmployee.get());
		}
		return null;
	}
}