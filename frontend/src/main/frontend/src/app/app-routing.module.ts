import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { EmployeesComponent } from './employees/employees.component';
import { EmployeeformComponent } from './employeeform/employeeform.component';
import {  EditemployeeComponent } from './editemployee/editemployee.component';
import { DeleteemployeeComponent } from './deleteemployee/deleteemployee.component';
import { WebsocketComponent } from './websocket/websocket.component';
import { EmployeeListComponent } from './employee-list/employee-list.component';

const routes: Routes = [
  { path: 'employees', component: EmployeesComponent },
  { path: 'addEmployee', component: EmployeeformComponent },
  { path: 'editEmployee', component: EditemployeeComponent },
  { path: 'deleteEmployee', component: DeleteemployeeComponent },
  { path: 'websocket', component: WebsocketComponent },
{ path: 'employeelist', component: EmployeeListComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
