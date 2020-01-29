package xo.example.model;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class EmployeeContainer {

	private static Set<Employee> employees = new HashSet<>();

	private static final String DEVELOPER = "Software developer";

	static {
		employees.add(new Employee(0, "Xingbo", 31, "male", DEVELOPER));
		employees.add(new Employee(1, "Milan", 29, "male", DEVELOPER));
		employees.add(new Employee(2, "Fabian", 26, "male", DEVELOPER));
		employees.add(new Employee(3, "Jonathen", 28, "male", DEVELOPER));
		employees.add(new Employee(4, "Philipp", 28, "male", DEVELOPER));
	}

	private EmployeeContainer() {
	}

	public static Set<Employee> getAllEmployes() {
		return Collections.unmodifiableSet(employees);
	}

	public static void addEmployee(final Employee employee) {
		employees.add(employee);
	}

	public static void removeEmployee(final Employee employee) {
		employees.remove(employee);
	}

	public static void removeById(final int id) {
		employees.removeIf(employee -> employee.getId() == id);
	}
}
