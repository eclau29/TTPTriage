import { Component, OnInit } from '@angular/core';
import { BarcodeFormat } from '@zxing/library';
import { Router } from '@angular/router';
import { ActivatedRoute } from '@angular/router';
import { Person } from './../../models/person';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-scanner',
  templateUrl: './scanner.component.html',
  styleUrls: ['./scanner.component.css']
})
export class ScannerComponent implements OnInit {
  // Class Fields
  person: Person = new Person();
  center: google.maps.LatLngLiteral;

  state$: Observable<string>;
  qrResultString: string = null;

  allowedFormats = [
    BarcodeFormat.AZTEC,
    BarcodeFormat.CODABAR,
    BarcodeFormat.CODE_128,
    BarcodeFormat.CODE_39,
    BarcodeFormat.CODE_93,
    BarcodeFormat.DATA_MATRIX,
    BarcodeFormat.EAN_8,
    BarcodeFormat.EAN_13,
    BarcodeFormat.ITF,
    BarcodeFormat.MAXICODE,
    BarcodeFormat.PDF_417,
    BarcodeFormat.QR_CODE,
    BarcodeFormat.RSS_14,
    BarcodeFormat.RSS_EXPANDED,
    BarcodeFormat.UPC_A,
    BarcodeFormat.UPC_E,
    BarcodeFormat.UPC_EAN_EXTENSION
  ];

  constructor(private router: Router, public activatedRoute: ActivatedRoute) { }

  ngOnInit() {
  }

  getLatLong() {
    navigator.geolocation.getCurrentPosition(position => {
      // this.person = {
        this.person.evalLatitude = position.coords.latitude,
        this.person.evalLongitude = position.coords.longitude,
      // };
      console.log(this.center);
    });
  }

  onCodeResult(resultString: string) {
    this.qrResultString = resultString;
    console.log(this.qrResultString);
    if (this.qrResultString) {
      this.person.barcodeNum = this.qrResultString;
      this.getLatLong();
      console.log(this.person);
      this.goToSeverity();
    }
  }

  goToSeverity() {
    if (this.qrResultString) {
      this.router.navigateByUrl('/severity', { state: { barcodeNum: this.qrResultString } });
    }
  }
}
