import { OnInit, Component } from '@angular/core';
import { ZAHTJEVI_ZA_VOZILA_URL } from 'src/app/config/api-paths';
import { Router } from '@angular/router';
import { AdsService } from 'src/app/services/ads.service';
import { ToastrService } from 'ngx-toastr';
import ZahtjevDTO from 'src/app/components/models/zahtjev-dto.model';

@Component({
    selector: 'app-agent-zahtjevi',
    templateUrl: './agent-zahtjevi.component.html',
  })
  export class AgentZahtjevi implements OnInit {

    zahtjevi = [];

    ngOnInit(): void {
        this.getAll();
    }

    constructor(private router: Router, private adsService: AdsService, private toastr: ToastrService) {

    }

    private getAll(): void {
        this.adsService.getAllZahtjevi().subscribe(data => {
          this.zahtjevi = data;
          console.log("Zahtevi: ", data);
        }, error => {
          this.toastr.error('There was an error while getting the ads');
        });
    }

    public onClickPotvrdi(zahtjev: ZahtjevDTO): void {
      this.adsService.vehicleStatusToReserved(zahtjev).subscribe(data => {
        this.toastr.success('Success');
        this.getAll();
      }, error => {
        this.toastr.error(error.error.message);
      });
    }

    public onClickCancel(zahtjev: ZahtjevDTO): void {
      this.adsService.vehicleStatusToCanceled(zahtjev).subscribe(data => {
        this.toastr.success('Success');
        this.getAll();
      }, error => {
        this.toastr.error(error.error.message);
      });
    }

  }