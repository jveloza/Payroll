package com.payroll.app.dto;

import org.hibernate.annotations.Immutable;

@Immutable
public class LoginDTO {
	private final String user;
	private final String password;

	public LoginDTO(String user, String password) {
		this.user = user;
		this.password = password;
	}

	public String getUser() {
		return user;
	}

	public String getPassword() {
		return password;
	}
}