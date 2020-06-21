import { Component, OnInit } from '@angular/core';
import { Poruka } from './poruka';
import { PorukeService } from './poruka.service';
import { DodajVoziloService } from '../components/dodajVozilo/dodajVozilo.service';
import { Oglas } from '../components/dodajVozilo/Oglas';


@Component({
  selector: 'app-poruka',
  templateUrl: './poruka.component.html',
  styleUrls: ['./poruka.component.css']
})
export class PorukaComponent implements OnInit {
  po =  new Poruka(null,null,null, null,null,null);
  oglasi : Oglas[];
 public posilj ;


  constructor(private porukaServis: PorukeService, private dodajVoziloServis : DodajVoziloService) { }

  ngOnInit(): void {
    this.dodajVoziloServis.getOglasi().subscribe(
      data=>{ 
        console.log(data+'oglasi');
          this.oglasi = data;
      },
      error=> console.error('Error!', error)
  )

  }
  onSubmit(){ 
   
    console.log(this.po);
      this.porukaServis.posalji(this.po)
     .subscribe(
         data=>{
          console.log('Success!', JSON.stringify(data))
          alert('Poruka poslata');
  
         } ,
          error=> console.error('Error!',error)
      )
  }


}
