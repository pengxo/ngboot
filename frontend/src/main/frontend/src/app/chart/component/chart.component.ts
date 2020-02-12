import {Component, OnInit, ViewChild} from '@angular/core';
import {ChartOptions, ChartType, ChartDataSets} from 'chart.js';
import {Label} from 'ng2-charts';
import {ChartService} from "../service/chart.service";
import {Chart} from "../class/chart";
import { BaseChartDirective } from 'ng2-charts';

@Component({
  selector: 'app-chart',
  templateUrl: './chart.component.html',
  styleUrls: ['./chart.component.css']
})
export class ChartComponent implements OnInit {

  public chartOptions: ChartOptions = {
    responsive: true,

    scales: {xAxes: [{}], yAxes: [{}]},
    plugins: {
      datalabels: {
        anchor: 'end',
        align: 'end',
      }
    }
  };
  public chartLabels=[];
  public chartType: ChartType = 'bar';
  public chartLegend = true;
  private chartDatas: Chart[];
  // @ts-ignore
  @ViewChild(BaseChartDirective) private _chart;

  public chartDataToDisplay: ChartDataSets[];
  dataReady: boolean = false;

  constructor(private chartService: ChartService) {
  }

  ngOnInit() {
    this.chartService.getChartDatas().subscribe(datas => {
      this.chartDatas = datas;
      debugger
      this.initializeData();
    });
  }

  private initializeData(): void {
    var carData = [];
    var bikeData = [];
    for (let data of this.chartDatas) {
      carData.push(data.nbrCar);
      bikeData.push(data.nbrBike);
      this.chartLabels.push(data.year);
    }
    debugger;
    this.chartDataToDisplay = [
      {data: carData, label: 'Car'},
      {data: bikeData, label: 'Bike'},
    ]
    this.dataReady = true;
  }

  public chartClicked({ event, active }: { event: MouseEvent, active: {}[] }): void {
    console.log(event, active);
  }

  public chartHovered({ event, active }: { event: MouseEvent, active: {}[] }): void {
    console.log(event, active);
  }

  public randomize(): void {
    let selectedSeries = this.generateNumber(1);
    debugger;
    let data = this.chartDataToDisplay[selectedSeries].data;
    if(!data){
      return;
    }
    for(let i = 0; i < data.length; i++){
      data[i] = this.generateNumber(100);
    }
    this._chart.chart.update();
  }


  private generateNumber(bound:number) {
    return Math.round(Math.random() * bound);
  }

  public setChartType(chartType: ChartType) {
    this.chartType = chartType;
  }
}
