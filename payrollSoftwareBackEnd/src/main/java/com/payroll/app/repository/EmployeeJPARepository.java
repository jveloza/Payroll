package com.payroll.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.payroll.app.entity.Employee;

public interface EmployeeJPARepository extends JpaRepository<Employee, Long>{

}
