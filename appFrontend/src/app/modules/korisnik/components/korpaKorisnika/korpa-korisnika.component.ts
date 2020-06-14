import { Component, OnInit, ViewChild } from '@angular/core';
import { AdsService } from 'src/app/services/ads.service';
import { ToastrService } from 'ngx-toastr';
import VehicleDTO from 'src/app/components/models/vehicle-dto.model';
import ZahtjevDTO from 'src/app/components/models/zahtjev-dto.model';

@Component({
  selector: 'app-korpa-korisnika',
  templateUrl: './korpa-korisnika.component.html',
})
export class KorpaKorisnikaComponent implements OnInit {

  categoryName: string = '';
  vozila = [];
  vidiZahtjev: boolean = false;
  zahtjev: ZahtjevDTO;

  constructor(private adsService: AdsService,
              private toastr: ToastrService) { }

  ngOnInit() {
    this.getAll();
  }

  private getAll(): void {
    this.adsService.getAllVehiclesFromCart().subscribe(data => {
      this.vozila = data;
      console.log("Sva vozila u korpi: ", this.vozila);
    }, error => {
      this.toastr.error('There was an error while getting all vehicles');
    });
  }

  public rentCar(vehicle: VehicleDTO): void {
    this.adsService.rentACarRequest(vehicle).subscribe(data => {
      this.toastr.success('Request for vehicle has been sent');
    }, error => {
      this.toastr.error(error.error.message);
    });
  }

  public onClickOpenZahtjev(voziloId: any, agentId: any): void {
    this.vidiZahtjev = true;
    console.log("ID vozila: ", voziloId);
    console.log("ID agenta: ", agentId);
    this.adsService.findVehicleById(voziloId, agentId).subscribe(data => {
      this.zahtjev = data;
      console.log("Zahtev: ", this.zahtjev);
      this.toastr.success('Success');
    }, error => {
      this.toastr.error(error.error.message);
    });
    
  }

  public onClickCloseZahtjev(): void {
    this.vidiZahtjev = false;
    
  }

  public onClickPlati(zahtjev: ZahtjevDTO): void {
    this.adsService.payForRent(zahtjev).subscribe(data => {
      this.toastr.success('Paid');
    }, error => {
      this.toastr.error(error.error.message);
    });
  }
  
  
}