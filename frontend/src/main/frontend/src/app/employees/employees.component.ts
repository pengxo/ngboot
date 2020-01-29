import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { Employee } from '../model/employee';
import { EmployeeServiceService } from '../service/employee-service.service'; 

@Component({
  selector: 'app-employees',
  templateUrl: './employees.component.html',
  styleUrls: ['./employees.component.css'],
})
export class EmployeesComponent implements OnInit {

employees: Employee[];

   @Output() selectedEmployeeEvent = new EventEmitter<Employee>();
 
  constructor(private employeeService: EmployeeServiceService) {
  }
 
  ngOnInit() {
    this.employeeService.findAll().subscribe(data => {
      this.employees = data;
    });
  }

  remove(employee: Employee){
	this.employeeService.delete(employee);
	this.selectedEmployeeEvent.emit(employee);
  }

  edit(employee: Employee){
	debugger
	this.employeeService.edit(employee); 
	this.selectedEmployeeEvent.emit(employee);
  }

}
