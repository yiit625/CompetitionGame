import {Component, OnInit, TemplateRef, ViewChild} from '@angular/core';
import {FormLayout} from 'ng-devui/form';
import {AppService, ScriptModel} from "../app-service";

@Component({
  selector: 'app-submit-page',
  templateUrl: './submit-page.component.html',
  styleUrls: ['./submit-page.component.scss'],
  providers: [AppService, ScriptModel]
})
export class SubmitPageComponent implements OnInit {
  layoutDirection: FormLayout = FormLayout.Horizontal;
  @ViewChild('customTemplate') customTemplate: TemplateRef<any>;
  msgs: Array<Object> = [];
  //(paste)="onKeydown($event)"
  loading = false;
  constructor(private service: AppService) {
  }

  ngOnInit(): void {
  }

  selectOptions = [{
    id: 1,
    label: 'Fibonacci Algorithm',
    inputParams: '5',
    outputParam: '5\n',
    description: 'Fibonacci sequence characterized by the fact that every number after the first two is the sum of the two preceding ones. Not: Please give input args parameter.'
  },
    {
      id: 2,
      label: 'Factorial Algorithm',
      inputParams: '5',
      outputParam: '120\n',
      description: 'The factorial function (symbol: !) says to multiply all whole numbers from our chosen number down to 1. Not: Please give input args parameter.'
    },
    {
      id: 3,
      label: 'Exponential Algorithm',
      inputParams: '5',
      outputParam: '32.0\n',
      description: 'The exponential function is a mathematical function denoted by x^{y}. Please think about x = 2. Not: Please give input args parameter.'
    }];

  formData = {
    inputValue: '',
    script: 'public class MyClass{ public static void main(String args[]){}}',
    selectValue: this.selectOptions[1]
  };

  onKeydown(event: any) {
    event.preventDefault();
  }

  submit() {
    this.loading = true;
    if (this.formData.inputValue === '') {
      this.msgs = [{severity: 'error', content: 'Enter name please'},];
      this.loading = false;
    } else {
      var model = new ScriptModel();
      model.script = this.formData.script
      if(this.formData.selectValue.id === 1) {
        model.outputParams = ['5\n', '8\n', '13\n']
      }
      else if(this.formData.selectValue.id === 2) {
        model.outputParams = ['120\n','720\n','5040\n']
      }
      else if(this.formData.selectValue.id === 3) {
        model.outputParams = ['32.0\n','64.0\n','128.0\n']
      }
      this.service.onlineEditor(model).subscribe((result: any) => {
        console.log(result);
        const _result = JSON.parse(JSON.stringify(result))
        if (_result.code === 200) {
          this.msgs = [{severity: 'success', content: result.message}];

            this.service.createPerson(this.formData.inputValue, this.formData.selectValue.id).subscribe((result3: any) => {
              const _result3 = JSON.parse(JSON.stringify(result3))
              if (_result3.code === 200) {
                this.msgs = [
                  {severity: 'success', content: 'Person is created!'},
                  {severity: 'success', content: result.message}
                ];
                this.loading = false;
              } else {
                this.msgs = [
                  {severity: 'success', content: 'Person is not created'},
                  {severity: 'success', content: result.message}
                ];
                this.loading = false;
              }
            });

        } else {
          this.service.createPersonWithoutTaskId(this.formData.inputValue).subscribe((result2: any) => {
            const _result2 = JSON.parse(JSON.stringify(result2))
            if (_result2.code === 200) {
              this.msgs = [
                {severity: 'success', content: 'Person is created!'},
                {severity: 'error', content: _result.message}
              ];
              this.loading = false;
            } else {
              this.msgs = [
                {severity: 'error', content: 'Person is not created!'},
                {severity: 'error', content: _result.message}
              ];
              this.loading = false;
            }
          });
        }
      });
    }
  }

}
