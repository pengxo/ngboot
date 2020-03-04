package com.pengxo.controller;

import com.pengxo.database.entity.Employee;
import com.pengxo.database.service.EmployeeService;
import com.pengxo.event.EmployeePublisher;
import com.pengxo.exception.EmployeeNotFoundException;
import com.pengxo.retry.RetryService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PreDestroy;
import java.sql.SQLException;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class EmployeeController {

    private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EmployeePublisher publisher;

    @Autowired
    private RetryService retryService;

    @GetMapping(path = "/hello")
    public ResponseEntity<String> sayHello() throws SQLException {
        retryService.retryTest();
        publisher.createNewEmployee();
        return new ResponseEntity<>("Hello from Spring Boot 2 with angular 2", HttpStatus.OK);
    }

    @ApiOperation("Gets all employees")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully got all employees."),
            @ApiResponse(code = 401, message = "Gets all employees failed."),
            @ApiResponse(code = 403, message = "Gets all employees failed.")})
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
