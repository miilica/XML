import { Component, OnInit } from '@angular/core';
import { Poruka } from '../poruka/poruka';
import { Router } from '@angular/router';
import { ListaPorukaService } from './lista-poruka.service';
import { User } from '../services/user';
import { UserService } from '../services/user.service';
import { USER_ID_KEY, USER_ROLE_KEY, USERNAME_KEY, USER_TOKEN_KEY } from './../config/local-storage-keys';

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

    var userId = parseInt(localStorage.getItem(USER_ID_KEY));
    this._listaServis.getMojePoruke(userId).subscribe(
    
      data=>{ 
       
        console.log('ziv samm, SAD ISPISI ID ' + userId)
          this.poruke = data;
      },
      error=> console.error('Error!', error)
  )
    }

  onSubmit(){ 
    this.router.navigate(['lista-poruka']);
  }

}
