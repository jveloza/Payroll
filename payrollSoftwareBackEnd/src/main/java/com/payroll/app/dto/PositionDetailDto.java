package com.payroll.app.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.hibernate.annotations.Immutable;

@Immutable
public class PositionDetailDto {

	private final Long id;
	private final String positionTitle;
	private final LocalDate hireDate; 
	private final String email;
	private final BigDecimal salary;
	private final Integer timeSalary;
	private final Boolean state;
	
	public PositionDetailDto(Long id, String positionTitle, LocalDate hireDate, String email, BigDecimal salary,
			Integer timeSalary, Boolean state) {
		super();
		this.id = id;
		this.positionTitle = positionTitle;
		this.hireDate = hireDate;
		this.email = email;
		this.salary = salary;
		this.timeSalary = timeSalary;
		this.state = state;
	}
	
	public String getPositionTitle() {
		return positionTitle;
	}
	
	public LocalDate getHireDate() {
		return hireDate;
	}
	
	public String getEmail() {
		return email;
	}
	
	public BigDecimal getSalary() {
		return salary;
	}
	
	public Integer getTimeSalary() {
		return timeSalary;
	}
	
	public Boolean getState() {
		return state;
	}

	public Long getId() {
		return id;
	}
}