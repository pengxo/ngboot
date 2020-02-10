package xo.example.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import xo.example.model.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
