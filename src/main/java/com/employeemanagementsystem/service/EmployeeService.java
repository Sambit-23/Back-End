package com.employeemanagementsystem.service;

import java.util.List;

import com.employeemanagementsystem.model.DepartmentDO;
import com.employeemanagementsystem.payload.EmployeeDto;

public interface EmployeeService {

	EmployeeDto createEmployee(EmployeeDto empDto,Integer deptId);
	EmployeeDto updateEmployee(EmployeeDto empDto,Integer empId);
	EmployeeDto getEmployeeById(Integer empId);
	List<EmployeeDto> getEmployeesByDeptId(DepartmentDO deptId);
	List<EmployeeDto> getAllEmployee();
	void deleteEmployee(Integer empId);
}
