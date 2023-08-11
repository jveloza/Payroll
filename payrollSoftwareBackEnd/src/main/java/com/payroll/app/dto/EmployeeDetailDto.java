package com.payroll.app.dto;

import java.time.LocalDate;

import org.hibernate.annotations.Immutable;

@Immutable
public class EmployeeDetailDto {

	private final Long id;
	private final String firstName;
	private final String middleName;
	private final String lastname;
	private final String locationCity;
	private final String address;
	private final LocalDate dateBirth;
	private final String telephone;
	
	public EmployeeDetailDto(Long id, String firstName, String middleName, String lastname, String locationCity,
			String address, LocalDate dateBirth, String telephone) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastname = lastname;
		this.locationCity = locationCity;
		this.address = address;
		this.dateBirth = dateBirth;
		this.telephone = telephone;
	}
	public Long getId() {
		return id;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public String getLastname() {
		return lastname;
	}
	public String getLocationCity() {
		return locationCity;
	}
	public String getAddress() {
		return address;
	}
	public LocalDate getDateBirth() {
		return dateBirth;
	}
	public String getTelephone() {
		return telephone;
	}
}