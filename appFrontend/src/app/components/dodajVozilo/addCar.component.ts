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
import { Slika } from './Slika';

@Component({
  selector: 'app-addCar',
  templateUrl: './addCar.component.html'
})
export class AddCarComponent implements OnInit {

 vozilo =  new Vozilo(null,null,null, null,null,null, null,null,null, null,null,null,null);
 public marke : MarkaAutomobila[];
 public klase : KlasaAutomobila[];
 public gorivo : TipGoriva[];
 public mjenjac : TipMjenjaca[];
 imageFiles = [];
 imageURLs: Slika[] = [];

  constructor(private _klasaServis : DodajKlasuAutomobilaService, 
    private _markaServis : DodajMarkuAutomobilaService, private _voziloServis : DodajVoziloService, private router: Router,
    private _gorivoServis : TipGorivaService, private _mjenjacServis : TipMjenjacaService) { }

  ngOnInit(): void {
    this._klasaServis.getKlase().subscribe(
      data=>{ 
        console.log(data+'klase');
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
      this.vozilo.slike = this.imageURLs;
      console.log(this.vozilo);
        this._voziloServis.dodajVozilo(this.vozilo)
       .subscribe(
           data=>{
            console.log('Success!', JSON.stringify(data))
            alert('Novo vozilo dodato!');
            this.router.navigate(['admin']);
           } ,
            error=> console.error('Error!',error)
        )
    }

    fileUpload(event) {
      if (event.target.files && event.target.files[0]) {
        var filesAmount = event.target.files.length;
        for (let i = 0; i < filesAmount; i++) {
          var reader = new FileReader();
  
          this.imageFiles.push(event.target.files[i]);
          reader.onload = (event: any) => {
            console.log(event.target.result)
            this.imageURLs.push(event.target.result);
          }
  
          reader.readAsDataURL(event.target.files[i]);
        }
      }
    }

}

