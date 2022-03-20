import { Component, OnInit } from '@angular/core';
import {AppService} from "../app-service";
import { TableWidthConfig } from 'ng-devui/data-table';

@Component({
  selector: 'app-grid-page',
  templateUrl: './grid-page.component.html',
  styleUrls: ['./grid-page.component.css'],
  providers: [AppService]
})
export class GridPageComponent implements OnInit {

  constructor(private service: AppService) { }
  basicDataSource=[]
  tableWidthConfig: TableWidthConfig[] = [
    {
      field: '#',
      width: '10px'
    },
    {
      field: 'playerName',
      width: '20px'
    },
    {
      field: 'taskName',
      width: '20px'
    },
  ];

  dataTableOptions = {
    columns: [
      {
        field: 'playerName',
        header: 'Name Of The Player',
        fieldType: 'text'
      },
      {
        field: 'taskName',
        header: 'Success Solution of the Algorithms',
        fieldType: 'text'
      },
    ]
  };

  ngOnInit(): void {
    this.service.batchPeople().subscribe((result: any) => {
      console.log(result)
      const _result = JSON.parse(JSON.stringify(result))
      console.log(_result.data[0].playerName)
      console.log(_result.data[0].taskListLength)
      this.basicDataSource = _result.data;
    });
  }

}
