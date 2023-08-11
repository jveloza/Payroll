package com.payroll.app.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payroll.app.dto.EmployeeDetailDto;
import com.payroll.app.dto.PositionDetailDto;
import com.payroll.app.entity.Position;
import com.payroll.app.repository.EmployeeJPARepository;
import com.payroll.app.repository.PositionJPARepository;
import com.payroll.app.response.EmployeePositionDetailResponse;
import com.payroll.app.response.EmployeePositionResponse;
import com.payroll.app.service.PositionEmployeeDataService;

@Service
public class PositionEmployeeDataServiceImpl implements PositionEmployeeDataService{

	@Autowired
	private EmployeeJPARepository employeeJPARepository;
	
	@Autowired
	private PositionJPARepository positionJPARepository;
	
	@Override
	public List<EmployeePositionResponse> getEmployeeList() {
		var lst = positionJPARepository.findAll();
		var responseLst = new ArrayList<EmployeePositionResponse>();
		if(!lst.isEmpty()) {
			for (Position position : lst) {
				var resp = new EmployeePositionResponse(position.getId()
						, position.getIdEmployee().getFirstName()+" "+position.getIdEmployee().getMiddleName()
						, position.getIdEmployee().getLastname()
						, position.getPositionTitle()
						, position.getHireDate()
						, position.getState());
				responseLst.add(resp);
			}
			return responseLst;
		}
		return null;
	}

	@Override
	public EmployeePositionDetailResponse getEmployeeDetail(Long id) {
		var oPosition = positionJPARepository.findById(id);
		if (!oPosition.isPresent()) {
			return null;
		}
		var positionDto = new PositionDetailDto(oPosition.get().getId(), 
				oPosition.get().getPositionTitle(),
				oPosition.get().getHireDate(),
				oPosition.get().getEmail(),
				oPosition.get().getSalary(),
				oPosition.get().getTimeSalary(),
				oPosition.get().getState());
		var employeeDto = new EmployeeDetailDto(oPosition.get().getIdEmployee().getId(),
				oPosition.get().getIdEmployee().getFirstName(),
				oPosition.get().getIdEmployee().getMiddleName(),
				oPosition.get().getIdEmployee().getLastname(),
				oPosition.get().getIdEmployee().getLocationCity(),
				oPosition.get().getIdEmployee().getAddress(),
				oPosition.get().getIdEmployee().getDateBirth(),
				oPosition.get().getIdEmployee().getTelephone());
		var response = new EmployeePositionDetailResponse(employeeDto,positionDto);
		return response;
	}

	@Override
	public Position createEmployee(Position position) {
		employeeJPARepository.save(position.getIdEmployee());
		return positionJPARepository.save(position);
	}

	@Override
	public Position updateEmployee(Position position, Long id) {
		var OPosition = positionJPARepository.findById(id);
		if(OPosition.isPresent()) {
			OPosition.get().setEmail(position.getEmail());
			OPosition.get().setHireDate(position.getHireDate());
			OPosition.get().setPositionTitle(position.getPositionTitle());
			OPosition.get().setSalary(position.getSalary());
			OPosition.get().setState(position.getState());
			OPosition.get().setTimeSalary(position.getTimeSalary());
			OPosition.get().getIdEmployee().setFirstName(position.getIdEmployee().getFirstName());
			OPosition.get().getIdEmployee().setMiddleName(position.getIdEmployee().getMiddleName());
			OPosition.get().getIdEmployee().setLastname(position.getIdEmployee().getLastname());
			OPosition.get().getIdEmployee().setAddress(position.getIdEmployee().getAddress());
			OPosition.get().getIdEmployee().setDateBirth(position.getIdEmployee().getDateBirth());
			OPosition.get().getIdEmployee().setLocationCity(position.getIdEmployee().getLocationCity());
			OPosition.get().getIdEmployee().setTelephone(position.getIdEmployee().getTelephone());
			return positionJPARepository.save(OPosition.get());
		}
		return null;
	}


}
