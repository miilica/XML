import { Component, OnInit } from '@angular/core';
import { Poruka } from './poruka';
import { PorukeService } from './poruka.service';
import { DodajVoziloService } from '../components/dodajVozilo/dodajVozilo.service';
import { Oglas } from '../components/dodajOglas/Oglas';
import { User } from '../services/user';
import { UserService } from '../services/user.service';
import { USER_ID_KEY, USER_ROLE_KEY, USERNAME_KEY, USER_TOKEN_KEY } from './../config/local-storage-keys';


@Component({
  selector: 'app-poruka',
  templateUrl: './poruka.component.html',
  styleUrls: ['./poruka.component.css']
})
export class PorukaComponent implements OnInit {
  po =  new Poruka(null,null,null, null,null,null);
  oglasi : Oglas[];
  posilj = new User (null,null,null,null,null, null, null,null);
  useri : User[];
  useri2: User[];
 userId: number;


  constructor(private porukaServis: PorukeService, private dodajVoziloServis : DodajVoziloService, private _userService : UserService) { }

  ngOnInit(): void {
     this.userId = parseInt(localStorage.getItem(USER_ID_KEY));
    this.dodajVoziloServis.getOglasi().subscribe(
      data=>{ 
        console.log(data+'oglasi');
          this.oglasi = data;
      },
      error=> console.error('Error!', error)
  )

  
    this._userService.getAll().subscribe(
       data=>{ 
         console.log('cao2')
         console.log(data);
           this.useri = data;
       },
         error=> console.error('Error!', error)
     )

  }

  isNotAdmin(u:User){
    if(u.authorities[0] !='ROLE_ADMIN' ){
      console.log(u.authorities[0]+' '+u.authorities[1])
      return true;
    }
  
    else return false;
  }
  onSubmit(){ 
   
    this.po.posiljalacId=this.userId;
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
