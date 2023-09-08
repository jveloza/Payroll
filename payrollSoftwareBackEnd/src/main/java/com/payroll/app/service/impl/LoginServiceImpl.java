package com.payroll.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.payroll.app.dto.LoginDTO;
import com.payroll.app.response.LoginResponse;
import com.payroll.app.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService{

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
    public LoginResponse login(LoginDTO loginDTO) {
        var user = "admin";
        var passEnc = "$2a$04$wF4lD.x9oWyDzARw7.27Ru6CoTmYDKWrHqZcjNiBAz0jgvAlqCYsu";
        if (loginDTO.getUser().equals(user)) {
            String password = loginDTO.getPassword();
            Boolean isPwdRight = passwordEncoder.matches(password, passEnc);
            if (isPwdRight) {
                return new LoginResponse("Login Success", true);
            } else {
                return new LoginResponse("password Not Match", false);
            }
        } else {
            return new LoginResponse("User not exits", false);
        }
    }
}