import { CatastropheService } from './../catastrophe.service';
import { Component, OnInit } from '@angular/core';
import { Catastrophe } from 'src/models/catastrophe';

@Component({
  selector: 'app-catastrophe',
  templateUrl: './catastrophe.component.html',
  styleUrls: ['./catastrophe.component.css']
})
export class CatastropheComponent implements OnInit {
  cat: Catastrophe = new Catastrophe();
  createdCat: any;

  constructor(private catService: CatastropheService) { }

  ngOnInit() {
  }

  // addCatEvent() {
  //   this.catService.createCat(this.cat).subscribe(
  //     data => {
  //       this.createdCat = data;
  //     },
  //     err => console.error(err)
  //   );
  // }

}
