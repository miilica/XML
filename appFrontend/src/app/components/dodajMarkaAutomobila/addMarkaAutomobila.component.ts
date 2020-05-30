import { Component, OnInit } from '@angular/core';
import { MarkaAutomobila } from './markaAutomobila';
import { DodajMarkuAutomobilaService } from './dodajMarkuAutomobila.service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-addMarkuAutomobila',
  templateUrl: './addMarkaAutomobila.component.html'
})
export class AddMarkaAutomobila implements OnInit {

 marka =  new MarkaAutomobila(null,null,null);
  constructor(private _markaServis : DodajMarkuAutomobilaService, private router : Router) { }

  ngOnInit(): void {

  }
  onSubmit(){ 
    console.log(this.marka);
      this._markaServis.dodajMarku(this.marka)
     .subscribe(
         data=>{
          console.log('Success!', JSON.stringify(data))
          alert('Nova marka dodata!');
          this.router.navigate(['welcome']);
         } ,
          error=> console.error('Error!',error)
      )
  }

}
