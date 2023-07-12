package com.employeemanagementsystem.payload;


import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor

public class DepartmentDto {

    private Integer id;
	
	@NotEmpty
	private String departmentName;
	
	@NotEmpty
	private String departmentCode;
}
