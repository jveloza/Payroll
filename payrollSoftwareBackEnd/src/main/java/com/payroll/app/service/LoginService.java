package com.payroll.app.service;

import com.payroll.app.dto.LoginDTO;
import com.payroll.app.response.LoginResponse;

public interface LoginService {

	LoginResponse login(LoginDTO loginDTO);
	
}
