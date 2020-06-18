import { Component, OnInit } from '@angular/core';
import { AdsService } from 'src/app/services/ads.service';
import { ToastrService } from 'ngx-toastr';
import { Router } from '@angular/router';
import ZahtjevDTO from 'src/app/components/models/zahtjev-dto.model';
import { Vozilo } from 'src/app/components/dodajVozilo/vozilo';

@Component({
    selector: 'app-oceniKomentarisi',
    templateUrl: './oceniKomentarisi.component.html',
  })
  export class OceniKomentarisiComponent implements OnInit {

    zahtjevi = [];
    currentRate = 3;
    komentar: any = "";

    constructor(private adsService: AdsService,
        private toastr: ToastrService,
        private router: Router) { }

    ngOnInit(): void {
        this.getAll();
    }

    private getAll(): void {
        this.adsService.getAllRateComment().subscribe(data => {
          this.zahtjevi = data;
          console.log("Svi zahtjevi: ", this.zahtjevi);
        }, error => {
          this.toastr.error('There was an error while getting all vehicles');
        });
    }

    rateVehicle(vozilo: Vozilo): void {
        console.log(vozilo)
        for(let z of this.zahtjevi) {
          if(z.vozilo.id == vozilo.id) {
            console.log("v: ", z);
            console.log("vozilo: ", vozilo);
            this.adsService.rateVehicle(z, this.currentRate).subscribe(
              date=> {
                alert('Vozilo je ocjenjeno!');
              }, error => {
                this.toastr.error('Error');
              });
          }
        }
    }

    commentVehicle(vozilo: Vozilo): void {
        console.log(vozilo)
        for(let z of this.zahtjevi) {
          if(z.vozilo.id == vozilo.id) {
            console.log("v: ", z);
            console.log("vozilo: ", vozilo);
            this.adsService.commentVehicle(z, this.komentar).subscribe(
              date=> {
                alert('Komentar je poslat!');
              }, error => {
                this.toastr.error('Error');
              });
          }
        }
    }
  }