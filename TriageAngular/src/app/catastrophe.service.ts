import { Person } from './../models/person';
import { Catastrophe } from './../models/catastrophe';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { environment } from '../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class CatastropheService {

  // SERVICE FIELDS
  // private baseUrl = 'http://localhost:8090/';
  // private baseUrl = 'http://ttptriage.com/';
  // private url = this.baseUrl + 'api/catastrophe/';
  private url = environment.baseUrl + 'api/catastrophe';

  // SERVICE METHODS
  index() {
    return this.http.get(this.url + '/all');
  }

  createCat(cat: Catastrophe) {
    return this.http.post(this.url + '/create', cat);
  }

  getCatById(catId: number) {
    return this.http.get(this.url + catId);
  }

  updateCatById(cat: Catastrophe) {
    return this.http.put(this.url + cat.catId, cat);
  }

  getAllCatVictims(catId: number) {
    return this.http.get(this.url + catId);
  }

  createVictims(person: Person) {
    return this.http.post(this.url + person.id + '/victims', person);
  }

  constructor(private http: HttpClient, private router: Router) {}
}
