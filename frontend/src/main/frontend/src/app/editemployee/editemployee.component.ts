import { Component, OnInit, Input } from '@angular/core';
import { Employee } from '../model/employee';
import { EmployeeServiceService } from '../service/employee-service.service'; 
import { Router } from '@angular/router';

@Component({
  selector: 'app-editemployee',
  templateUrl: './editemployee.component.html',
  styleUrls: ['./editemployee.component.css'],
})
export class EditemployeeComponent {
	
	 editedEmployee: Employee

  constructor(private employeeService: EmployeeServiceService, 
              private router: Router) {
	debugger;
	this.editedEmployee = new Employee();
    this.editedEmployee= this.employeeService.getCurrentEmployee();
  }
 
  onSubmit() {
    this.employeeService.edit(this.editedEmployee).subscribe(result => {
	this.editedEmployee = result;
	this.gotoEmployeeList();
	});
  }
 
  gotoEmployeeList() {
    this.router.navigate(['/employees']); 
  }

  updateEmployee(newItem: Employee) {
	debugger;
    this.editedEmployee = newItem;
  }

}
