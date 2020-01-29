package xo.example;

import java.util.Set;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import xo.example.model.Employee;
import xo.example.model.EmployeeContainer;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class HelloController {

	@GetMapping(path = "/hello")
	public String sayHello() {
		return "Hello from Spring Boot 2 with angular 2";
	}

	@GetMapping("/employees")
	public Set<Employee> getEmployees() {
		return EmployeeContainer.getAllEmployes();
	}

	@PostMapping("/addEmployee")
	public void addEmployees(@RequestBody final Employee employee) {
		EmployeeContainer.addEmployee(employee);
	}

	@PostMapping("/deleteEmployee")
	public void deleteEmployee(@RequestBody final Employee employee) {
		EmployeeContainer.removeById(employee.getId());
	}

	@PostMapping("/editEmployee")
	public void editEmployee(@RequestBody final Employee employee) {
		EmployeeContainer.removeById(employee.getId());
		EmployeeContainer.addEmployee(employee);
	}

}
