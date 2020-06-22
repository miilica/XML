import { Component, OnInit } from '@angular/core';
import { Poruka } from '../poruka/poruka';
import { Router } from '@angular/router';
import { ListaPorukaService } from './lista-poruka.service';

@Component({
  selector: 'app-lista-poruka',
  templateUrl: './lista-poruka.component.html',
  styleUrls: ['./lista-poruka.component.css']
})
export class ListaPorukaComponent implements OnInit {

  public poruke : Poruka[];


  constructor(private router: Router, private _listaServis: ListaPorukaService) { }

  ngOnInit(): void {
 //   this._listaServis.getMojePoruke().subscribe(
 //     data=>{ 
 //       console.log(data+'klase');
 //         this.klase = data;
 //     },
  //    error=> console.error('Error!', error)
  //)
  }

  onSubmit(){ 
    this.router.navigate(['lista-poruka']);
  }

}
