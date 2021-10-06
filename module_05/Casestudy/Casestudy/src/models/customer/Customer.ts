import {CustomerType} from "./CustomerType";

export interface Customer {
  customerId: number;
  customerCode?: string;
  customerName?: string;
  customerDob?: string;
  customerIdCard?: string;
  customerPhone?: string;
  customerEmail?: string;
  customerAddress?: string;
  customerType?: CustomerType;
}
