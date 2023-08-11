package com.payroll.app.response;

import org.hibernate.annotations.Immutable;

import com.payroll.app.dto.EmployeeDetailDto;
import com.payroll.app.dto.PositionDetailDto;

@Immutable
public class EmployeePositionDetailResponse {

	private final EmployeeDetailDto employeeDetail;
	private final PositionDetailDto positionDetail;
	
	public EmployeePositionDetailResponse(EmployeeDetailDto employeeDetail, PositionDetailDto positionDetail) {
		super();
		this.employeeDetail = employeeDetail;
		this.positionDetail = positionDetail;
	}
	
	public EmployeeDetailDto getEmployeeDetail() {
		return employeeDetail;
	}
	
	public PositionDetailDto getPositionDetail() {
		return positionDetail;
	}
}