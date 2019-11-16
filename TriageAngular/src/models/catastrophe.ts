import { Person } from './person';

export class Catastrophe {
  catId: number;
  catName: string;
  catLatitude: number;
  catLongitude: number;
  victims: Person[];

  constructor(
    catId?: number,
    catName?: string,
    catLatitude?: number,
    catLongitude?: number,
    victims?: Person[]
  ) { 
    this.catId = catId;
    this.catName = catName;
    this.catLatitude = catLatitude;
    this.catLongitude = catLongitude;
    this.victims = victims;
  }
}
