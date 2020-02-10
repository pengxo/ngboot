package com.pengxo.model.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pengxo.model.entity.Employee;
import com.pengxo.model.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Transactional
	public List<Employee> getAllEmployes() {
		return Collections.unmodifiableList(employeeRepository.findAll());
	}

	@Transactional
	public void saveEmployee(final Employee employee) {
		employeeRepository.save(employee);
	}

	@Transactional
	public void updateEmployee(final Employee employee) {
		final Optional<Employee> optional = employeeRepository.findById(employee.getId());

		if (optional.isPresent()) {
			final Employee loadedEmployee = optional.get();
			loadedEmployee.setAge(employee.getAge());
			loadedEmployee.setGender(employee.getGender());
			loadedEmployee.setJob(employee.getJob());
			loadedEmployee.setName(employee.getName());
		}
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void removeEmployee(final Employee employee) {
		removeById(employee.getId());
	}

	@Transactional
	public void removeById(final Long id) {
		employeeRepository.findById(id).ifPresent(em -> employeeRepository.delete(em));
	}
}
