import { Component, OnInit} from '@angular/core';
import { Vozilo } from './vozilo';
import { MarkaAutomobila } from '../dodajMarkaAutomobila/markaAutomobila';
import { KlasaAutomobila } from '../dodajKlasaAutomobila/klasaAutomobila';
import { DodajKlasuAutomobilaService } from '../dodajKlasaAutomobila/dodajKlasuAutomobila.service';
import { DodajMarkuAutomobilaService } from '../dodajMarkaAutomobila/dodajMarkuAutomobila.service';
import { DodajVoziloService } from './dodajVozilo.service';
import { Router } from '@angular/router';
import { TipGoriva } from '../tipGoriva/tipGoriva';
import { TipMjenjaca } from '../tipMjenjaca/tipMjenjaca';
import { TipGorivaService } from '../tipGoriva/tipGoriva.service';
import { TipMjenjacaService } from '../tipMjenjaca/tipMjenjaca.service';
import { error } from '@angular/compiler/src/util';

@Component({
  selector: 'app-addCar',
  templateUrl: './addCar.component.html'
})
export class AddCarComponent implements OnInit {

 vozilo =  new Vozilo(null,null,null, null,null,null, null,null,null, null,null);
 public marke : MarkaAutomobila[];
 public klase : KlasaAutomobila[];
 public gorivo : TipGoriva[];
 public mjenjac : TipMjenjaca[];

  constructor(private _klasaServis : DodajKlasuAutomobilaService, 
    private _markaServis : DodajMarkuAutomobilaService, private _voziloServis : DodajVoziloService, private router: Router,
    private _gorivoServis : TipGorivaService, private _mjenjacServis : TipMjenjacaService) { }

  ngOnInit(): void {
    this._klasaServis.getKlase().subscribe(
      data=>{ 
          this.klase = data;
      },
      error=> console.error('Error!', error)
  )
  this._markaServis.getMarke().subscribe(
    data=>{ 
      console.log(data);
        this.marke = data;
    },
    error=> console.error('Error!', error)
)
this._gorivoServis.getTipoveGoriva().subscribe(
  data => {
    this.gorivo = data;
  },
  error=> console.error('Error!', error)
)
this._mjenjacServis.getTipoveMjenjaca().subscribe(
  data => {
    this.mjenjac = data;
  },
  error=> console.error('Error!', error)
)
}
  onSubmit(){ 
      console.log(this.vozilo);
        this._voziloServis.dodajVozilo(this.vozilo)
       .subscribe(
           data=>{
            console.log('Success!', JSON.stringify(data))
            alert('Novo vozilo dodato!');
            this.router.navigate(['welcome']);
           } ,
            error=> console.error('Error!',error)
        )
    }

}

