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
    label: 'Option1'
  },
    {
      id: 2,
      label: 'Option2'
    },
    {
      id: 3,
      label: 'Option3'
    }];

  formData = {
    inputValue: '',
    textareaValue: '',
    script: '',
    selectValue: this.selectOptions[1]
  };

  submit() {
    console.log(this.formData)
  }


}
