import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { MatTableModule } from '@angular/material'  

import { AppRoutingModule } from './app-routing.module';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';
import { EmployeesComponent } from './employees/employees.component';
import { EmployeeformComponent } from './employeeform/employeeform.component';
import { EmployeeServiceService } from './service/employee-service.service';
import { DeleteemployeeComponent } from './deleteemployee/deleteemployee.component';
import { EditemployeeComponent } from './editemployee/editemployee.component';
import { WebsocketComponent } from './websocket/websocket.component';
import { NoopAnimationsModule } from '@angular/platform-browser/animations';
import { StoreModule } from '@ngrx/store';
import { reducers, metaReducers } from './reducers';
import { EmployeeListComponent } from './employee-list/employee-list.component';

@NgModule({
  declarations: [
    AppComponent,
    EmployeesComponent,
    EmployeeformComponent,
    DeleteemployeeComponent,
    EditemployeeComponent,
    WebsocketComponent,
    EmployeeListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
	MatTableModule,
    NoopAnimationsModule,
    StoreModule.forRoot(reducers, {
      metaReducers,
      runtimeChecks: {
        strictStateImmutability: true,
        strictActionImmutability: true
      }
    })
  ],
  providers: [EmployeeServiceService, DeleteemployeeComponent, EditemployeeComponent],
  bootstrap: [AppComponent]
})
export class AppModule { }
