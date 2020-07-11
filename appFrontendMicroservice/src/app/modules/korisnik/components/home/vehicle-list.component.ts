import { Component, OnInit, ViewChild } from '@angular/core';
import { AdsService } from 'src/app/services/ads.service';
import { ToastrService } from 'ngx-toastr';
import VehicleDTO from 'src/app/components/models/vehicle-dto.model';
import ZahtjevDTO from 'src/app/components/models/zahtjev-dto.model';
import { Router } from '@angular/router';
import { PORUKE_HOME_PAGE } from 'src/app/config/api-paths';
import { Vozilo } from 'src/app/components/dodajVozilo/vozilo';

@Component({
  selector: 'app-vehicle-list',
  templateUrl: './vehicle-list.component.html',
})
export class VehicleListComponent implements OnInit {

  categoryName: string = '';
  oglasi = [];
  vozila = [];

  constructor(private adsService: AdsService,
              private toastr: ToastrService, 
              private router: Router) { }

  ngOnInit() {
    this.getAllAds();
  }

  private getAllAds(): void {
    this.adsService.getAllVehicles().subscribe(data => {
      this.vozila = data;
      console.log("Sva vozila: ", this.vozila);
    }, error => {
      this.toastr.error('There was an error while getting all vehicles');
    });
  }

  public addToCart(vehicle: Vozilo): void {
    this.adsService.addVehicleToCart(vehicle).subscribe(data => {
      this.toastr.success('Vehicle has been added to cart');
    }, error => {
      this.toastr.error(error.error.message);
    });
  }

  onClickPoruke() : void{
    this.router.navigate([PORUKE_HOME_PAGE]);
  }

  onClickDodajOglas(): void{
    this.router.navigate(['agent/dodajOglas']);
  }

  onClickDodajCjenovnik() : void{
    this.router.navigate(['cjenovnik']);
  }

  onClickZavreniZahtjevi(){
    this.router.navigate(['zavrseniZahtjevi']);
  }
}