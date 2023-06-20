package com.employeemanagementsystem.service;

import java.util.List;

import com.employeemanagementsystem.payload.EmployeeDto;

public interface EmployeeService {

	EmployeeDto createEmployee(EmployeeDto empDto);
	EmployeeDto updateEmployee(EmployeeDto empDto,Integer empId);
	EmployeeDto getEmployeeById(Integer empId);
	List<EmployeeDto> getAllEmployee();
	void deleteEmployee(Integer empId);
}
