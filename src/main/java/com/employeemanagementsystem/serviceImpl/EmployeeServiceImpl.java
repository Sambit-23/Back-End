package com.employeemanagementsystem.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeemanagementsystem.exception.ResourceNotFoundException;
import com.employeemanagementsystem.model.Employee;
import com.employeemanagementsystem.payload.EmployeeDto;
import com.employeemanagementsystem.repository.EmployeeRepository;
import com.employeemanagementsystem.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository empRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public EmployeeDto createEmployee(EmployeeDto empDto) {
		Employee emp = this.modelMapper.map(empDto, Employee.class);
		Employee createEmployee = this.empRepo.save(emp);
		return this.modelMapper.map(createEmployee, EmployeeDto.class);
	}

	@Override
	public EmployeeDto updateEmployee(EmployeeDto empDto, Integer empId) {
		Employee emp = this.empRepo.findById(empId)
				.orElseThrow(() -> new ResourceNotFoundException("no employee found"));
		emp.setEmailId(empDto.getEmailId());
		emp.setFirstName(empDto.getFirstName());
		emp.setLastName(empDto.getLastName());

		Employee updateEmployee = this.empRepo.save(emp);

		return this.modelMapper.map(updateEmployee, EmployeeDto.class);
	}

	@Override
	public EmployeeDto getEmployeeById(Integer empId) {
		Employee emp = this.empRepo.findById(empId)
				.orElseThrow(()-> new ResourceNotFoundException("No employee found"));
		
		return this.modelMapper.map(emp, EmployeeDto.class);
	}

	@Override
	public List<EmployeeDto> getAllEmployee() {
		List<Employee> allEmployee = this.empRepo.findAll();
		return allEmployee.stream().map((emp)->this.modelMapper.map(emp, EmployeeDto.class)).collect(Collectors.toList());
	}

	@Override
	public void deleteEmployee(Integer empId) {
		Employee emp = this.empRepo.findById(empId)
				.orElseThrow(()-> new ResourceNotFoundException("No employee found"));
		this.empRepo.delete(emp);
		
	}

}
