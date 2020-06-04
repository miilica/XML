import { Component, OnInit } from '@angular/core';

import { Router } from '@angular/router';
import { TipGoriva } from './tipGoriva';
import { TipGorivaService } from './tipGoriva.service';


@Component({
  selector: 'app-tipGoriva',
  templateUrl: './tipGoriva.component.html'
})
export class AddTipGoriva implements OnInit {

 gorivo =  new TipGoriva(null,null);
  constructor(private _tipGorivaServis : TipGorivaService, private router : Router) { }

  ngOnInit(): void {

  }
  onSubmit(){ 
    console.log(this.gorivo);
      this._tipGorivaServis.dodajTipGoriva(this.gorivo)
     .subscribe(
         data=>{
          console.log('Success!', JSON.stringify(data))
          alert('Novi tip goriva dodata!');
          this.router.navigate(['welcome']);
         } ,
          error=> console.error('Error!',error)
      )
  }

}
