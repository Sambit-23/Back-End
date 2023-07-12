package com.employeemanagementsystem.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="departments")
@Getter
@Setter
@NoArgsConstructor

public class DepartmentDO {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name="department_name")
	private String departmentName;
	
	@Column(name="department_code")
	private String departmentCode;
	
	@OneToMany(mappedBy = "department",cascade = CascadeType.ALL)
	private List<EmployeeDO> employees =new ArrayList<>();
	
}
