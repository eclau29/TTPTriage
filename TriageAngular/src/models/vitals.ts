import { Person } from './person';

export class Vitals {
  id: number;
  diastolicBloodPressure: number;
  systolicBloodPressure: number;
  respirationRate: number;
  pulseOx: number;
  timestamp: Date;
  severity: Severity;
  person: Person;
  latitude: number;
  longitude: number;

  constructor(
    id?: number,
    diastolicBloodPressure?: number,
    systolicBloodPressure?: number,
    respirationRate?: number,
    pulseOx?: number,
    timestamp?: Date,
    severity?: Severity,
    person?: Person,
    latitude?: number,
    longitude?: number
  ) {
    this.id = id;
    this.diastolicBloodPressure = diastolicBloodPressure;
    this.systolicBloodPressure = systolicBloodPressure;
    this.respirationRate = respirationRate;
    this.pulseOx = pulseOx;
    this.timestamp = timestamp;
    this.severity = severity;
    this.person = person;
    this.latitude = latitude;
    this.longitude = longitude;
  }
}
