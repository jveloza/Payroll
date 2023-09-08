package com.payroll.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.payroll.app.dto.LoginDTO;
import com.payroll.app.response.LoginResponse;
import com.payroll.app.service.LoginService;

@RestController
@CrossOrigin
@RequestMapping("login")
public class LoginController {

	@Autowired
	private LoginService loginService;
	
	@PostMapping()
    public ResponseEntity<?> loginEmployee(@RequestBody LoginDTO loginDTO)
    {
        LoginResponse loginResponse = loginService.login(loginDTO);
        return ResponseEntity.ok(loginResponse);
    }
}
