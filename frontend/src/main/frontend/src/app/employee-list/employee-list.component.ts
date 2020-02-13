import {Component, OnInit, EventEmitter, Output, ViewChild, AfterViewInit} from '@angular/core';
import { Employee } from '../model/employee';
import { EmployeeServiceService } from '../service/employee-service.service';
import {MatPaginator} from "@angular/material/paginator";
import {MatTableDataSource} from "@angular/material/table";
import {MatSort} from "@angular/material/sort";



@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css']
})
export class EmployeeListComponent implements OnInit {

	 displayedColumns: string[] = ['Id', 'name', 'Age', 'Gender','Position'	,'Remove','Edit'];

  employees: MatTableDataSource<Employee>;

   @Output() selectedEmployeeEvent = new EventEmitter<Employee>();

  @ViewChild(MatPaginator, {static: true}) paginator: MatPaginator;

  @ViewChild(MatSort, {static: true}) sort: MatSort;

  constructor(private employeeService: EmployeeServiceService) {
  }

  ngOnInit() {
    this.employeeService.findAll().subscribe(data => {
      debugger
      this.employees = new MatTableDataSource<Employee>(data);
      this.employees.paginator = this.paginator;
      this.employees.sort = this.sort;
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
