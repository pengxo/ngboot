package com.pengxo.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pengxo.model.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
