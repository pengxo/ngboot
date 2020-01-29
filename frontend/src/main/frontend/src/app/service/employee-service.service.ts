import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Employee } from '../model/employee';
import { Observable } from 'rxjs'; 

@Injectable()
export class EmployeeServiceService {

  private employeesUrl: string;

  private addEmployeeUrl: string;

  private deleteEmployeeUrl: string;

   private editEmployeeUrl: string;

   public currentEmployee: Employee;
 
  constructor(private http: HttpClient) {
    this.employeesUrl = 'http://localhost:8080/employees';
    this.addEmployeeUrl = 'http://localhost:8080/addEmployee';
    this.deleteEmployeeUrl = 'http://localhost:8080/deleteEmployee';
    this.editEmployeeUrl = 'http://localhost:8080/editEmployee';
  }
 
  public findAll(): Observable<Employee[]> {
    return this.http.get<Employee[]>(this.employeesUrl);
  }
 
  public save(employee: Employee) {
	this.currentEmployee = employee;
    return this.http.post<Employee>(this.addEmployeeUrl, employee);
  }

  public delete(employee: Employee) {
	debugger;
	this.currentEmployee = employee;
    return this.http.post<Employee>(this.deleteEmployeeUrl, employee).subscribe(() => console.log("user deleted"));
  }

  public edit(employee: Employee) {
	this.currentEmployee = employee;
    return this.http.post<Employee>(this.editEmployeeUrl, employee);
  }

  public getCurrentEmployee() {
    return this.currentEmployee;
  }
}
