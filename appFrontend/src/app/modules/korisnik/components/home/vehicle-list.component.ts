import { Component, OnInit, ViewChild } from '@angular/core';
import { AdsService } from 'src/app/services/ads.service';
import { ToastrService } from 'ngx-toastr';
import VehicleDTO from 'src/app/components/models/vehicle-dto.model';
import ZahtjevDTO from 'src/app/components/models/zahtjev-dto.model';

@Component({
  selector: 'app-vehicle-list',
  templateUrl: './vehicle-list.component.html',
})
export class VehicleListComponent implements OnInit {

  categoryName: string = '';
  oglasi = [];
  vozila = [];

  constructor(private adsService: AdsService,
              private toastr: ToastrService) { }

  ngOnInit() {
    this.getAllAds();
  }

  private getAllAds(): void {
    this.adsService.getAllAds().subscribe(data => {
      this.oglasi = data;
      console.log("Svi oglasi: ", this.oglasi);
    }, error => {
      this.toastr.error('There was an error while getting all ads');
    });

    this.adsService.getAllVehicles().subscribe(data => {
      this.vozila = data;
      console.log("Sva vozila: ", this.vozila);
    }, error => {
      this.toastr.error('There was an error while getting all vehicles');
    });
  }

  public addToCart(vehicle: VehicleDTO): void {
    this.adsService.addVehicleToCart(vehicle).subscribe(data => {
      this.toastr.success('Vehicle has been added to cart');
    }, error => {
      this.toastr.error(error.error.message);
    });
  }
}