import {Employee} from "../employee/Employee";
import {Customer} from "../customer/Customer";
import {Service} from "../service/Service";

export interface Contract {
  id: number;
  dateStart?: string;
  dateEnd?: string;
  deposit?: number;
  totalAmount?: number;
  employee?: Employee;
  customer?: Customer;
  service?: Service;
}
