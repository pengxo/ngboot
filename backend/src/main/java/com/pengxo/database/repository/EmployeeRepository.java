package com.pengxo.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pengxo.database.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
