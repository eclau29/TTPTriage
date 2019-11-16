import { Person } from './../../models/person';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-severity',
  templateUrl: './severity.component.html',
  styleUrls: ['./severity.component.css']
})
export class SeverityComponent implements OnInit {
  // Class Fields
  person: Person = new Person();
  center: google.maps.LatLngLiteral;

  state$: Observable<string>;

  constructor(public activatedRoute: ActivatedRoute) { }

  ngOnInit() {
    this.person.barcodeNum = window.history.state.barcodeNum;
    console.log(this.person);
  }
  getLatLong() {
    navigator.geolocation.getCurrentPosition(position => {
      this.center = {
        lat: position.coords.latitude,
        lng: position.coords.longitude,
      };
      console.log(this.center);
    });
  }
}
