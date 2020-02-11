import { Component, OnInit, EventEmitter, Output } from '@angular/core';
import { Employee } from '../model/employee';
import { EmployeeServiceService } from '../service/employee-service.service';



@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css']
})
export class EmployeeListComponent implements OnInit {
	
	 displayedColumns: string[] = ['Id', 'Name', 'Age', 'Gender','Position'	,'Remove','Edit'];

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
