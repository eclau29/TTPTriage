import { Person } from './person';

export class Symptoms {
  symptomsId: number;
  bodyPart: string;
  injury: string;
  person: Person;

  constructor(
    symptomsId?: number,
    bodyPart?: string,
    injury?: string,
    person?: Person
  ) {
    this.symptomsId = symptomsId;
    this.bodyPart = bodyPart;
    this.injury = injury;
    this.person = person;
  }
}
