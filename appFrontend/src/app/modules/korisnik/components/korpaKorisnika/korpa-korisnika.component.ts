import { Component, OnInit, ViewChild } from '@angular/core';
import { AdsService } from 'src/app/services/ads.service';
import { ToastrService } from 'ngx-toastr';
import VehicleDTO from 'src/app/components/models/vehicle-dto.model';

@Component({
  selector: 'app-korpa-korisnika',
  templateUrl: './korpa-korisnika.component.html',
})
export class KorpaKorisnikaComponent implements OnInit {

  categoryName: string = '';
  vozila = [];

  constructor(private adsSerice: AdsService,
              private toastr: ToastrService) { }

  ngOnInit() {
    this.getAll();
  }

  private getAll(): void {
    this.adsSerice.getAllVehiclesFromCart().subscribe(data => {
      this.vozila = data;
      console.log("Sva vozila u korpi: ", this.vozila);
    }, error => {
      this.toastr.error('There was an error while getting all vehicles');
    });
  }

  public rentCar(vehicle: VehicleDTO): void {
    this.adsSerice.rentACarRequest(vehicle).subscribe(data => {
      this.toastr.success('Request for vehicle has been sent');
    }, error => {
      this.toastr.error(error.error.message);
    });
  }
  
}