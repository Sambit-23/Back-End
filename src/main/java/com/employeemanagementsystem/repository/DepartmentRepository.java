package com.employeemanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employeemanagementsystem.model.DepartmentDO;

public interface DepartmentRepository extends JpaRepository<DepartmentDO, Integer> {

}
