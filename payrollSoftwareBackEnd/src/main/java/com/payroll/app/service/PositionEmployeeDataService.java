package com.payroll.app.service;

import java.util.List;

import com.payroll.app.entity.Position;
import com.payroll.app.response.EmployeePositionDetailResponse;
import com.payroll.app.response.EmployeePositionResponse;

public interface PositionEmployeeDataService {

	List<EmployeePositionResponse> getEmployeeList();
	
	EmployeePositionDetailResponse getEmployeeDetail(Long id);
	
	Position createEmployee(Position position);
	
	Position updateEmployee(Position position, Long id);
	
	
}
