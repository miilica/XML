import { Component, OnInit } from '@angular/core';

import { Router } from '@angular/router';
import { TipMjenjaca } from './tipMjenjaca';
import { TipMjenjacaService } from './tipMjenjaca.service';


@Component({
  selector: 'app-tipMjenjaca',
  templateUrl: './tipMjenjaca.component.html'
})
export class DodajTipMjenjaca implements OnInit {

 tip =  new TipMjenjaca(null,null);
  constructor(private _tipMjenjcaServis : TipMjenjacaService, private router : Router) { }

  ngOnInit(): void {
  }

  
  onSubmit(){ 
      this._tipMjenjcaServis.dodajTipMjenjaca(this.tip)
     .subscribe(
         data=>{
          console.log('Success!', JSON.stringify(data))
          alert('Novi tip mjenjaca dodat!');
          this.router.navigate(['admin']);
         } ,
          error=> console.error('Error!',error)
      )
  }

}
