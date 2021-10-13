import {Destination} from "./Destination";

export interface Bus {
  id: number;
  busCode?: string;
  busType?: string;
  busName?: string;
  destinationFrom?: Destination;
  destinationTo?: Destination;
  busPhone?: string;
  busEmail?: string;
  hourFrom?: string;
  hourTo?: string;
}
