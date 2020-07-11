import { Component, OnInit } from '@angular/core';
import { AdsService } from 'src/app/services/ads.service';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Vozilo } from 'src/app/components/dodajVozilo/vozilo';

@Component({
    selector: 'app-agent-termini',
    templateUrl: './agent-termini.component.html',
  })
  export class AgentTermini implements OnInit {

    termini = [];
    vidiZahtjev: boolean = false;
    trenutnoVozilo: Vozilo;
    dodajKilometrePom: number = 0;

    ngOnInit(): void {
        this.getAll();
    }

    constructor(private router: Router, private adsService: AdsService, private toastr: ToastrService) {

    }

    private getAll(): void {
        this.adsService.getAllTermini().subscribe(data => {
          this.termini = data;
          console.log("Termini: ", data);
        }, error => {
          this.toastr.error('There was an error while getting the ads');
        });
    }

    public onClickOpenTermin(vozilo: Vozilo): void {
      this.vidiZahtjev = true;
      this.trenutnoVozilo = vozilo;
      console.log("Vozilo ", this.trenutnoVozilo);
    }

    public onClickDodaj(): void {
      console.log("KM ", this.dodajKilometrePom);
      this.adsService.addKmToVehicle(this.trenutnoVozilo, this.dodajKilometrePom).subscribe(data => {
        alert('Kilometraza je dodata!');
      }, error => {
        this.toastr.error('There was an error while getting the ads');
      });
      
    }
  }