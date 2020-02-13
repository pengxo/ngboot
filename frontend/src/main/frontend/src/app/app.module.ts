import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { MatTableModule } from '@angular/material'
import { ChartsModule } from 'ng2-charts';

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
import {BrowserAnimationsModule, NoopAnimationsModule} from '@angular/platform-browser/animations';
import { StoreModule } from '@ngrx/store';
import { reducers, metaReducers } from './reducers';
import { EmployeeListComponent } from './employee-list/employee-list.component';
import {MatButtonModule} from "@angular/material/button";
import {MatPaginatorModule} from "@angular/material/paginator";
import { ChartComponent } from './chart/component/chart.component';
import {MatInputModule} from "@angular/material/input";
import {MatSortModule} from "@angular/material/sort";

@NgModule({
  declarations: [
    AppComponent,
    EmployeesComponent,
    EmployeeformComponent,
    DeleteemployeeComponent,
    EditemployeeComponent,
    WebsocketComponent,
    EmployeeListComponent,
    ChartComponent
  ],
  imports: [
    ChartsModule,
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
    }),
    MatButtonModule,
    MatPaginatorModule,
    MatInputModule,
    MatSortModule,
    BrowserAnimationsModule
  ],
  providers: [EmployeeServiceService, DeleteemployeeComponent, EditemployeeComponent],
  bootstrap: [AppComponent]
})
export class AppModule { }
