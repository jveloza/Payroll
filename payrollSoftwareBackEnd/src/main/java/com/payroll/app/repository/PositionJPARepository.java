package com.payroll.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.payroll.app.entity.Position;

@Repository
public interface PositionJPARepository extends JpaRepository<Position, Long>{

}
