import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { EmployeeServiceService } from '../service/employee-service.service';
import { Employee } from '../model/employee';

@Component({
  selector: 'app-employeeform',
  templateUrl: './employeeform.component.html',
  styleUrls: ['./employeeform.component.css']
})
export class EmployeeformComponent {

 employee: Employee;
 isClicked = false;
 
  constructor(
    private route: ActivatedRoute, 
      private router: Router, 
        private employeeService: EmployeeServiceService) {
    this.employee = new Employee();
  }
 
  onSubmit() {
	this.isClicked = true;
    this.employeeService.save(this.employee).subscribe(result => this.gotoEmployeeList());
  }
 
  gotoEmployeeList() {
    this.router.navigate(['/employees']); 
  }
}
