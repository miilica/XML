import { Component, OnInit } from '@angular/core';
import { KlasaAutomobila } from './klasaAutomobila';
import { DodajKlasuAutomobilaService } from './dodajKlasuAutomobila.service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-dodajKlasu',
  templateUrl: './dodajKlasuAutomobila.component.html'
})
export class DodajKlasuAutomobila implements OnInit {

 klasa =  new KlasaAutomobila(null,null);
 constructor(private _klasaServis : DodajKlasuAutomobilaService, private router : Router) { }

  ngOnInit(): void {

  }
  onSubmit(){ 
    console.log(this.klasa);
      this._klasaServis.dodajKlasu(this.klasa)
     .subscribe(
         data=>{
          console.log('Success!', JSON.stringify(data))
          alert('Nova klasa automobila dodata!');
          this.router.navigate(['welcome']);
         } ,
          error=> console.error('Error!',error)
      )
  }

}
