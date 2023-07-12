package com.employeemanagementsystem.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.employeemanagementsystem.exception.ResourceNotFoundException;
import com.employeemanagementsystem.model.DepartmentDO;
import com.employeemanagementsystem.payload.DepartmentDto;
import com.employeemanagementsystem.repository.DepartmentRepository;
import com.employeemanagementsystem.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public DepartmentDto createDepartment(DepartmentDto deptDto) {
		DepartmentDO dept = this.modelMapper.map(deptDto, DepartmentDO.class);
		DepartmentDO createDept = this.departmentRepo.save(dept);
		return this.modelMapper.map(createDept, DepartmentDto.class);
	}

	@Override
	public DepartmentDto updateDepartment(DepartmentDto deptDto, Integer deptId) {

		DepartmentDO dept = this.departmentRepo.findById(deptId)
				.orElseThrow(() -> new ResourceNotFoundException("No Dept with this id found"));
		dept.setDepartmentName(deptDto.getDepartmentName());
		dept.setDepartmentCode(deptDto.getDepartmentCode());

		DepartmentDO updateDept = this.departmentRepo.save(dept);

		return this.modelMapper.map(updateDept, DepartmentDto.class);

	}

	@Override
	public DepartmentDto getDepartmentById(Integer deptId) {
		DepartmentDO dept = this.departmentRepo.findById(deptId).
		orElseThrow(()-> new ResourceNotFoundException("No Dept with this id found"));
		
		return this.modelMapper.map(dept, DepartmentDto.class);
	}

	@Override
	public List<DepartmentDto> getAllDepartment() {
		List<DepartmentDO> departments = this.departmentRepo.findAll();
		
		return departments.stream().map((dept)-> this.modelMapper.map(dept, DepartmentDto.class)).collect(Collectors.toList());
	}

	@Override
	public void deleteDepartment(Integer deptId) {
		DepartmentDO dept = this.departmentRepo.findById(deptId)
				.orElseThrow(()-> new ResourceNotFoundException("No Dept with this id found"));
		this.departmentRepo.delete(dept);

	}

}
