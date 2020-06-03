import { Component, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Vozilo } from '../dodajVozilo/vozilo';
import { DodajVoziloService } from '../dodajVozilo/dodajVozilo.service';

@Component({
  selector: 'app-vehicule-list',
  templateUrl: './vehicule-list.component.html',
})
export class VehiculeListComponent implements OnInit {

  errorMessage: String = 'There was an error filling up the form. Please try again.';
  cars = new Array<Vozilo>();
  car = new Vozilo(null,null,null, null,null,null, null,null,null, null,null);

  sortDirectionCar: String = 'asc';
  sortDirectionVan: String = 'asc';
  sortFieldCar: String = 'model';
  sortFieldVan: String = 'model';
  sortFieldsCar: Array<String> = [
    'model',
    'plateNumber',
    'seats',
    'price'
  ];
  sortFieldsVan: Array<String> = [
    'model',
    'plateNumber',
    'maxWeight',
    'price'
  ];

  constructor(private vehiculeService: DodajVoziloService) { }

  ngOnInit() {
  }


  
}