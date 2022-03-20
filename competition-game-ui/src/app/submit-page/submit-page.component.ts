import { Component, OnInit } from '@angular/core';
import { FormLayout } from 'ng-devui/form';

@Component({
  selector: 'app-submit-page',
  templateUrl: './submit-page.component.html',
  styleUrls: ['./submit-page.component.scss']
})
export class SubmitPageComponent implements OnInit {
  layoutDirection: FormLayout = FormLayout.Horizontal;
  constructor() {
  }
  ngOnInit(): void {
  }

  selectOptions = [{
    id: 1,
    label: 'Fibonacci Algorithm',
    inputParams: '5',
    outputParam: '5',
    description: 'Fibonacci sequence characterized by the fact that every number after the first two is the sum of the two preceding ones'
  },
    {
      id: 2,
      label: 'Factorial Algorithm',
      inputParams: '5',
      outputParam: '120',
      description: 'The factorial function (symbol: !) says to multiply all whole numbers from our chosen number down to 1.'
    },
    {
      id: 3,
      label: 'Exponential Algorithm',
      inputParams: '5',
      outputParam: '32',
      description: 'The exponential function is a mathematical function denoted by x^{y}. Please think about x = 2.'
    }];

  formData = {
    inputValue: '',
    script: '',
    selectValue: this.selectOptions[1]
  };

  submit() {
    console.log(this.formData)
  }


}
