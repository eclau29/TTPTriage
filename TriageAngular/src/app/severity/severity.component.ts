import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-severity',
  templateUrl: './severity.component.html',
  styleUrls: ['./severity.component.css']
})
export class SeverityComponent implements OnInit {
  center: google.maps.LatLngLiteral;

  constructor() { }

  ngOnInit() {
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
