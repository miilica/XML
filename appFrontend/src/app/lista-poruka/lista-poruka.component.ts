import { Component, OnInit } from '@angular/core';
import { Poruka } from '../poruka/poruka';
import { Router } from '@angular/router';
import { ListaPorukaService } from './lista-poruka.service';
import { User } from '../services/user';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-lista-poruka',
  templateUrl: './lista-poruka.component.html',
  styleUrls: ['./lista-poruka.component.css']
})
export class ListaPorukaComponent implements OnInit {

  public poruke : Poruka[];
  user = new User (null,null,null,null,null, null, null,null);
  Id : number
  pom : number = 0;

  constructor(private router: Router, private _userService : UserService , private _listaServis: ListaPorukaService) { }

  ngOnInit(): void {

    this._userService.getLoggedUser().subscribe(
      data=>{ 
       
        console.log(data+'tu samm'+data.id);
          this.user = data;
          console.log(this.user.id+"jajajjajajajjjaj")
          this.Id = this.user.id;
          this.pom = 1;
      },
      error=> console.error('Error!', error)
  )
if(this.pom=1){
    this._listaServis.getMojePoruke(6).subscribe(
    
      data=>{ 
       
        console.log('ziv samm')
          this.poruke = data;
      },
      error=> console.error('Error!', error)
  )
    }
  }

  onSubmit(){ 
    this.router.navigate(['lista-poruka']);
  }

}
