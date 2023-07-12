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

import com.employeemanagementsystem.payload.ApiResponse;
import com.employeemanagementsystem.payload.DepartmentDto;
import com.employeemanagementsystem.service.DepartmentService;

@CrossOrigin(origins ="http://localhost:3000/")
@RestController
@RequestMapping("api/v1")
public class DepartmentController {
	@Autowired
	private DepartmentService deptService;
	
	//Create Department
	@PostMapping("/department")
	public ResponseEntity<DepartmentDto> createDepartment(@Valid @RequestBody DepartmentDto deptDto){
		DepartmentDto createDepartment = this.deptService.createDepartment(deptDto);
		return new ResponseEntity<DepartmentDto>(createDepartment,HttpStatus.CREATED);
		
	}
	//Update Department
	@PutMapping("/department/{deptId}")
	public ResponseEntity<DepartmentDto> updateDepartment(
			@RequestBody DepartmentDto deptDto,
			@PathVariable Integer deptId){
		
		DepartmentDto updateDepartment = this.deptService.updateDepartment(deptDto, deptId);
		return new ResponseEntity<DepartmentDto>(updateDepartment, HttpStatus.CREATED);
	}
	
	//Get Department By Id
	@GetMapping("/department/{deptId}")
	public ResponseEntity<DepartmentDto> getDepartmentById(@PathVariable Integer deptId){
		DepartmentDto departmentById = this.deptService.getDepartmentById(deptId);
		return new ResponseEntity<DepartmentDto>(departmentById,HttpStatus.OK);
			
	}
	//Get All Department
	@GetMapping("/departments")
	public ResponseEntity<List<DepartmentDto>> getAllDepartment(){
		List<DepartmentDto> allDepartment = this.deptService.getAllDepartment();
		return new ResponseEntity<List<DepartmentDto>>(allDepartment,HttpStatus.OK);
		
	}
	
	//Delete Department by Id
	@DeleteMapping("/department/{deptId}")
	public ResponseEntity<ApiResponse> deleteDepartmentById(@PathVariable Integer deptId){
		this.deptService.deleteDepartment(deptId);
		return ResponseEntity.ok(new ApiResponse("Department Deleted Successfully", false));
	}	
	

	
}
