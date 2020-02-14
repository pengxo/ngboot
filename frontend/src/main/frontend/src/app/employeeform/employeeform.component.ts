import {Component} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {EmployeeServiceService} from '../service/employee-service.service';
import {Employee} from '../model/employee';

@Component({
  selector: 'app-employeeform',
  templateUrl: './employeeform.component.html',
  styleUrls: ['./employeeform.component.css']
})
export class EmployeeformComponent {

  employee: Employee;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private employeeService: EmployeeServiceService) {
    this.employee = new Employee();
  }

  onSubmit() {
    if (this.employee.name == null || this.employee.name.trim() == "") {
      alert("The name of the employee could not be empty!");
      return;
    }
    this.employeeService.save(this.employee).subscribe(result => this.gotoEmployeeList());
  }

  gotoEmployeeList() {
    this.router.navigate(['/employeelist']);
  }
}
