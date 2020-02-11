package com.pengxo.database.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pengxo.database.entity.Employee;
import com.pengxo.database.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Transactional
	public List<Employee> getAllEmployes() {
		return employeeRepository.findAll();
	}

	@Transactional
	public void saveEmployee(final Employee employee) {
		employeeRepository.save(employee);
	}

	/**
	 * Updates the employee for the changes from the use.
	 * {@link EmployeeService#saveEmployee(Employee)} can also be used.
	 *
	 * @param employee
	 */
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
	public void deleteEmployee(final Employee employee) {
		deleteById(employee.getId());
	}

	@Transactional
	public void deleteById(final Long id) {
		employeeRepository.findById(id).ifPresent(em -> employeeRepository.delete(em));
	}
}
