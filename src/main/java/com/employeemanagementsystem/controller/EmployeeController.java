package com.employeemanagementsystem.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employeemanagementsystem.model.DepartmentDO;
import com.employeemanagementsystem.payload.ApiResponse;
import com.employeemanagementsystem.payload.EmployeeDto;
import com.employeemanagementsystem.service.EmployeeService;


@CrossOrigin(origins ="http://localhost:3000/")
@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

	@Autowired
	private EmployeeService empService;

	
	//Create
	
	@PostMapping("/employee/{deptId}")
	public ResponseEntity<EmployeeDto> createEmployee(@Valid @RequestBody EmployeeDto empDto,@PathVariable Integer deptId) {

		EmployeeDto createEmployee = this.empService.createEmployee(empDto,deptId);
		return new ResponseEntity<EmployeeDto>(createEmployee, HttpStatus.CREATED);
	}

	//update
	
	@PutMapping("/employee/{Id}")
	public ResponseEntity<EmployeeDto> updateEmployeeEntity(
			@RequestBody EmployeeDto empDto, 
			@PathVariable Integer Id) {
		EmployeeDto updateEmployee = this.empService.updateEmployee(empDto, Id);
		return new ResponseEntity<EmployeeDto>(updateEmployee, HttpStatus.CREATED);
	}
	
	// Get Employee by id
	
	@GetMapping("/employee/{Id}")
	public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable Integer Id) {
		return new ResponseEntity<EmployeeDto>(this.empService.getEmployeeById(Id), HttpStatus.OK);
	}

	//Get All employees
	
	@GetMapping("/employees")
	public ResponseEntity<List<EmployeeDto>> getAllEmployee() {
		return new ResponseEntity<List<EmployeeDto>>(this.empService.getAllEmployee(), HttpStatus.OK);
	}

	//Delete employee
	
	@DeleteMapping("/employee/{Id}")
	public ResponseEntity<ApiResponse> deleteEmployeeById(@PathVariable Integer Id) {
		this.empService.deleteEmployee(Id);
		return ResponseEntity.ok(new ApiResponse("Employee Deleted !!", false));

	}
	
	//Filter employee by dept id
	
	@GetMapping("/employees/dept/{Id}")
	public ResponseEntity<List<EmployeeDto>> getEmployeeByDept(@PathVariable DepartmentDO Id){
		return new ResponseEntity<List<EmployeeDto>>(this.empService.getEmployeesByDeptId(Id),HttpStatus.OK);
	}

}
