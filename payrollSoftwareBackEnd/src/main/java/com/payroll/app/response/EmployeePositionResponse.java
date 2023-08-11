package com.payroll.app.response;

import java.time.LocalDate;

import org.hibernate.annotations.Immutable;

@Immutable
public final class EmployeePositionResponse {

	 private final Long idPosition;
	 private final String firstName;
	 private final String lastName;
	 private final String positionTitle;
	 private final LocalDate dateArrival; 
	 private final Boolean status;
	
	 public EmployeePositionResponse(Long idPosition, String firstName, String lastName, String positionTitle, LocalDate dateArrival,
			Boolean status) {
		super();
		this.idPosition = idPosition;
		this.firstName = firstName;
		this.lastName = lastName;
		this.positionTitle = positionTitle;
		this.dateArrival = dateArrival;
		this.status = status;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getPositionTitle() {
		return positionTitle;
	}

	public LocalDate getDateArrival() {
		return dateArrival;
	}

	public Boolean getStatus() {
		return status;
	}

	public Long getIdPosition() {
		return idPosition;
	}
}