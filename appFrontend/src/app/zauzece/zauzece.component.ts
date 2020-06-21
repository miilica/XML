import { OnInit, Component } from '@angular/core';
import { Router } from '@angular/router';
import { zauzeceAutomobilaService } from '../services/zauzece.service';
import { Vozilo } from '../components/dodajVozilo/vozilo';


@Component({
    selector: 'app-zauzece',
    templateUrl: './zauzece.component.html',
    styleUrls: ['zauzece.component.css']
  })
  export class ZauzeceComponent implements OnInit {

    public vozila: [];
    vozilo: {};


    public datumOd: "";
    public datumDo: "";

    
    constructor(private router: Router, private zauzeceService: zauzeceAutomobilaService) {

    }

    ngOnInit(): void {
      this.zauzeceService.getVoziloAgent().subscribe(
        data => {this.vozila = data}
      );
    } 
       onClickDodaj() : void{
      console.log(this.vozilo);
      let zauzece: any = {
        id: null,
        zauzetOd: this.datumOd,
        zauzetDo: this.datumDo,
        voziloId: this.vozilo
      }

      this.zauzeceService.zauzeceAutomobil(zauzece).subscribe(
        data => {console.log('Uspjesno dodato zauzece automobila!')
          this.datumDo = "";
          this.datumOd = "";
          this.vozilo ={};
      },
        err => console.error('Niste uspjeli da dodate zauzece automobila!')
      );
    }


  }
  