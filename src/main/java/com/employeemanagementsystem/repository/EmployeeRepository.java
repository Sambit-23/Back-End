package com.employeemanagementsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employeemanagementsystem.model.DepartmentDO;
import com.employeemanagementsystem.model.EmployeeDO;

public interface EmployeeRepository extends JpaRepository<EmployeeDO, Integer>{
	
	List<EmployeeDO> findByDepartment(DepartmentDO department);

	
	

}
