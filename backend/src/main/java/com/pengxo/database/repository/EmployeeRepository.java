package com.pengxo.database.repository;

import com.pengxo.database.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findByName(String name);

    List<Employee> findByAgeGreaterThan(Integer age);

    List<Employee> findByAgeAndName(Integer age, String name);

}
