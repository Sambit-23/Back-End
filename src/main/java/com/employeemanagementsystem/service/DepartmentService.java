package com.employeemanagementsystem.service;

import java.util.List;

import com.employeemanagementsystem.payload.DepartmentDto;
import com.employeemanagementsystem.payload.EmployeeDto;

public interface DepartmentService {

	DepartmentDto createDepartment(DepartmentDto deptDto);
	DepartmentDto updateDepartment(DepartmentDto deptDto,Integer deptId);
	DepartmentDto getDepartmentById(Integer deptId);
	List<DepartmentDto> getAllDepartment();
	void deleteDepartment(Integer deptId);
	
}
