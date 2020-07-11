import { Component, OnInit} from '@angular/core';
import { Router } from '@angular/router';
import { Oglas } from './Oglas';
import { DodajVoziloService } from '../dodajVozilo/dodajVozilo.service';
import { DodajOglasService } from './dodajOglas.service';
import { Vozilo } from '../dodajVozilo/vozilo';
import { USER_ID_KEY, USER_ROLE_KEY, USERNAME_KEY, USER_TOKEN_KEY } from '../../config/local-storage-keys';
import { Cjenovnik } from 'src/app/search/shared/cjenovnik';
import { CjenovnikService } from 'src/app/cjenovnik/cjenovnik.service';


@Component({
  selector: 'app-addOglas',
  templateUrl: './dodajOglas.component.html'
})
export class DodajOglasComponent implements OnInit {

 oglas =  new Oglas(null,null,null, null,null,null, null,null);
 public vozila : Vozilo[];
 userId : number;
 cjenovnici: Cjenovnik[];


  constructor(private _voziloServis : DodajVoziloService, private router: Router,
   private _oglasService : DodajOglasService, private cjenovnikService: CjenovnikService) { }

  ngOnInit(): void {

    this.oglas.userId = parseInt(localStorage.getItem(USER_ID_KEY));

    this._oglasService.getVozila().subscribe(
      data => {
        this.vozila = data;
        console.log(data);
      },
      error=> console.error('Error!', error)
    )
    
    this.cjenovnikService.getCjenovnik(localStorage.getItem("user-username-key")).subscribe(
      data => {
        this.cjenovnici = data;
      },
      error=> console.error('Error!', error)
    )

}
  onSubmit(){ 
   
      console.log(this.oglas);
        this._oglasService.dodajOglas(this.oglas)
       .subscribe(
           data=>{
            console.log('Success!', JSON.stringify(data))
            alert('Novi oglas dodat!');
            //this.router.navigate(['admin']);
           } ,
            error=> console.error('Error!',error)
        )
    }


}

