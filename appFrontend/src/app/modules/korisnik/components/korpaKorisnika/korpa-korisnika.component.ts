import { Component, OnInit, ViewChild } from '@angular/core';
import { AdsService } from 'src/app/services/ads.service';
import { ToastrService } from 'ngx-toastr';
import VehicleDTO from 'src/app/components/models/vehicle-dto.model';
import ZahtjevDTO from 'src/app/components/models/zahtjev-dto.model';
import { Vozilo } from 'src/app/components/dodajVozilo/vozilo';

@Component({
  selector: 'app-korpa-korisnika',
  templateUrl: './korpa-korisnika.component.html',
})
export class KorpaKorisnikaComponent implements OnInit {

  categoryName: string = '';
  vozila = [];
  vidiZahtjev: boolean = false;
  zahtjev: ZahtjevDTO;
  bundleCheckBox: boolean = false;
  listaZahtjeva: VehicleDTO[] = [];
  max3: any = 0;
  pojedinacniZahtjev = null;
  bundleZahtjev = null;

  vozilaZaIspis = [];

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
    if(!this.bundleCheckBox) {  //pojedinacni zahtevi
      this.adsService.rentACarRequest(vehicle).subscribe(data => {
        this.toastr.success('Request for vehicle has been sent');
      }, error => {
        this.toastr.error(error.error.message);
      });
    } else {  //bundle zahtevi
      if(this.max3 < 3) {
        this.listaZahtjeva.push(vehicle);
        this.max3++;
      } else {
        console.log("Max je 3");
      }
    }
  }

  public onClickBundleZahtev(): void {
    this.adsService.rentACarRequestBundle(this.listaZahtjeva).subscribe(data => {
      this.toastr.success('Request for vehicles has been sent');
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
      if(this.zahtjev.bundle) {
        this.bundleZahtjev = this.zahtjev;
      } else {
        this.pojedinacniZahtjev = this.zahtjev;
      }
      console.log("Pojedinacni: ", this.pojedinacniZahtjev);
      console.log("Bundle: ", this.bundleZahtjev);
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