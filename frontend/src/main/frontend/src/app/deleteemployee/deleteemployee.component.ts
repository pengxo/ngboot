import { Component, Input} from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { EmployeeServiceService } from '../service/employee-service.service';
import { Employee } from '../model/employee';


@Component({
	selector: 'app-deleteemployee',
	templateUrl: './deleteemployee.component.html',
	styleUrls: ['./deleteemployee.component.css'],
})
export class DeleteemployeeComponent {

	@Input() localEmployee: Employee;

	constructor(
		private employeeService: EmployeeServiceService) {
			debugger;
	    this.localEmployee = employeeService.currentEmployee;
	}

}
