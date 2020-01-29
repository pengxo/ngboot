import { Component } from '@angular/core';
import { Employee } from './model/employee';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Spring Boot with Angular 2 Application';
  globalEmployee: Employee

  updateEmployee(newItem: Employee) {
	debugger;
    this.globalEmployee = newItem;
  }

}
