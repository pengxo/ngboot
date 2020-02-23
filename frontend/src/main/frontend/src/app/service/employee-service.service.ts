import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Employee} from '../model/employee';
import {Observable} from 'rxjs';

@Injectable()
export class EmployeeServiceService {

  public currentEmployee: Employee;
  private employeesUrl: string;
  private addEmployeeUrl: string;
  private deleteEmployeeUrl: string;
  private editEmployeeUrl: string;

  constructor(private http: HttpClient) {
    this.employeesUrl = 'https://ngboot.cfapps.io/employees';
    this.addEmployeeUrl = 'https://ngboot.cfapps.io/addEmployee';
    this.deleteEmployeeUrl = 'https://ngboot.cfapps.io/deleteEmployee';
    this.editEmployeeUrl = 'https://ngboot.cfapps.io/editEmployee';
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
    debugger
    this.currentEmployee = employee;
    return this.http.post<Employee>(this.editEmployeeUrl, employee);
  }

  public getCurrentEmployee() {
    return this.currentEmployee;
  }
}
