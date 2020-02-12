import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Chart} from "../class/chart";

@Injectable({
  providedIn: 'root'
})
export class ChartService {

private chartUrl:string;

  constructor(private http: HttpClient) {
    this.chartUrl = 'http://localhost:8080/chart';
  }

  public getChartDatas(): Observable<Chart[]> {
    return this.http.get<Chart[]>(this.chartUrl);
  }
}
