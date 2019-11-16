import { Vitals } from './vitals';
import { Symptoms } from './symptoms';
export class Person {
  id: number;
  initalEval: Date;
  gender: string;
  vitalsList: Vitals[];
  symptomsList: Symptoms[];
  barcodeNum: string;
  evalLatitude: number;
  evalLongitude: number;

  constructor(
    id?: number,
    initalEval?: Date,
    gender?: string,
    vitalsList?: Vitals[],
    symptomsList?: Symptoms[],
    barcodeNum?: string,
    evalLatitude?: number,
    evalLongitude?: number
  ) {
    this.id = id;
    this.initalEval = initalEval;
    this.gender = gender;
    this.vitalsList = vitalsList;
    this.symptomsList = symptomsList;
    this.barcodeNum = barcodeNum;
    this.evalLatitude = evalLatitude;
    this.evalLongitude = evalLongitude;
  }
}
