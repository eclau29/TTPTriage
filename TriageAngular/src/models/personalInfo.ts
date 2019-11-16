import { Person } from './person';

export class PersonalInfo {
  id: number;
  firstName: string;
  middleName: string;
  lastName: string;
  dateOfBirth: string;
  person: Person;

  constructor(
    id?: number,
    firstName?: string,
    middleName?: string,
    lastName?: string,
    dateOfBirth?: string,
    person?: Person,
  ) {
    this.id = id;
    this.firstName = firstName;
    this.middleName = middleName;
    this.lastName = lastName;
    this.dateOfBirth = dateOfBirth;
    this.person = person;
  }
}
