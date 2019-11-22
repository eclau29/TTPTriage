import { Person } from './person';

export class Symptoms {
  symptomsId: number;
  bodyPart: string;
  injury: string;
  person: Person;
  timestamp: Date;

  constructor(
    symptomsId?: number,
    bodyPart?: string,
    injury?: string,
    person?: Person,
    timestamp?: Date
  ) {
    this.symptomsId = symptomsId;
    this.bodyPart = bodyPart;
    this.injury = injury;
    this.person = person;
    this.timestamp = timestamp;
  }
}
