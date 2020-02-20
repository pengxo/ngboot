package com.pengxo.controller;

import com.pengxo.database.entity.Employee;
import com.pengxo.database.service.EmployeeService;
import com.pengxo.event.EmployeePublisher;
import com.pengxo.exception.EmployeeNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PreDestroy;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class EmployeeController {

    private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EmployeePublisher publisher;

    @GetMapping(path = "/hello")
    public ResponseEntity<String> sayHello() {
        publisher.createNewEmployee();
        return new ResponseEntity<>("Hello from Spring Boot 2 with angular 2", HttpStatus.OK);
    }

    @GetMapping(path = "/employees", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Employee> getEmployees() {
        return employeeService.getAllEmployes();
    }

    @PostMapping("/addEmployee")
    public void addEmployees(@RequestBody final Employee employee) {
        if (employee.getName() == null) throw new EmployeeNotFoundException();
        employeeService.saveEmployee(employee);
    }

    @PostMapping("/deleteEmployee")
    public void deleteEmployee(@RequestBody final Employee employee) {
        employeeService.deleteEmployee(employee);
    }

    @PostMapping("/editEmployee")
    public void editEmployee(@RequestBody final Employee employee) {
        employeeService.updateEmployee(employee);
    }

    @PreDestroy
    private void preDestroy() {
        logger.debug("The EmployeeController bean is removed from the container.");
    }

}
