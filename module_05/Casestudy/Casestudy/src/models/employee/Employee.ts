import {Position} from "./Position";
import {Division} from "./Division";
import {Education} from "./Education";

export interface Employee {
  id: number;
  employeeCode?: string;
  employeeName?: string;
  employeeDob?: string;
  employeeIdCard?: string;
  employeeSalary?: number;
  employeePhone?: string;
  employeeEmail?: string;
  employeeAddress?: string;
  employeePosition?: Position;
  employeeDivision?: Division;
  employeeEducation?: Education;
}


