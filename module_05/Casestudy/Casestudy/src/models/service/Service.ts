import {ServiceType} from "./service-type";

export interface Service {
  id: number;
  serviceCode?: string;
  serviceName?: string;
  serviceArea?: number;
  serviceFloor?: number;
  serviceCapacity?: number;
  serviceCost?: number;
  serviceStatus?: string;
  serviceType?: ServiceType;
}
