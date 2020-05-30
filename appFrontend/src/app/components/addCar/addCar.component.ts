import { Component, OnInit } from '@angular/core';
import { Vozilo } from './vozilo';

@Component({
  selector: 'app-addCar',
  templateUrl: './addCar.component.html'
})
export class AddCarComponent implements OnInit {

 vozilo =  new Vozilo(null,null,null, null,null,null, null,null,null, null,null);
  constructor() { }

  ngOnInit(): void {
  }
  onSubmit(){

  }

}
