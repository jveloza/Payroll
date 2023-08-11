package com.payroll.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.payroll.app.entity.Position;
import com.payroll.app.service.PositionEmployeeDataService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("employee")
public class EmployeeDataController {
	
	@Autowired
	private PositionEmployeeDataService positionEmployeeDataService;
	
	@GetMapping("/all")
	public ResponseEntity<?> employeeList(){
		return ResponseEntity.ok(positionEmployeeDataService.getEmployeeList());
	}
	
	@GetMapping("/detail/{id}")
	public ResponseEntity<?> employeeDetail(@PathVariable(value = "id") Long employeeId){
		return ResponseEntity.ok(positionEmployeeDataService.getEmployeeDetail(employeeId));
	}
	
	@PostMapping()
	public ResponseEntity<?> createEmployee(@Valid @RequestBody Position position){
		positionEmployeeDataService.createEmployee(position);
		return ResponseEntity.ok("Ok");
	}
	
	@PutMapping("{id}")
	public ResponseEntity<?> updateEmployee(@PathVariable(value = "id") Long positionId,
			@Valid @RequestBody  Position position){
		positionEmployeeDataService.updateEmployee(position, positionId);
		return ResponseEntity.ok("Ok");
	}
}
