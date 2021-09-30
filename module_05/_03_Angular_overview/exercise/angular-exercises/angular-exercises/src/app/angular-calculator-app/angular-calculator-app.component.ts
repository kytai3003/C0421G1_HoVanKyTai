import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-angular-calculator-app',
  templateUrl: './angular-calculator-app.component.html',
  styleUrls: ['./angular-calculator-app.component.css']
})
export class AngularCalculatorAppComponent implements OnInit {

  firstNumber: number;
  secondNumber: number;
  operator: string;
  result: string;

  calculate() {
    switch (this.operator) {
      case '+':
        this.result = Number(this.firstNumber) + Number(this.secondNumber) + '';
        break;
      case '-':
        this.result = this.firstNumber - this.secondNumber +'';
        break;
      case '*':
        this.result = this.firstNumber * this.secondNumber +'';
        break;
      case '/':
        if (this.secondNumber === 0) {
          this.result = undefined;
        } else {
          this.result = this.firstNumber / this.secondNumber +'';
        }
        break;
    }
  }

  onchangeFirstNum(value) {
    this.firstNumber = value;
  }

  onchangeSecondNum(value) {
    this.secondNumber = value;
  }

  onchangeOperator(value) {
    this.operator = value;
  }

  constructor() { }

  ngOnInit(): void {
  }

}
