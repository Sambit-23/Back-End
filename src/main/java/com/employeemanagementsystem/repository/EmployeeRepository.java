package com.employeemanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employeemanagementsystem.model.Employee;


public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
