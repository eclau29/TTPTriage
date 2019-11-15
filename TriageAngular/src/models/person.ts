import { Vitals } from './vitals';
import { Symptoms } from './symptoms';
export class Person {
  id: number;
  gpsLocation: string;
  initalEval: Date;
  gender: string;
  vitalsList: Vitals[];
  symptomsList: Symptoms[];

  constructor() {}
}
