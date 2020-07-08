import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { zauzeceAutomobilaService } from '../services/zauzece.service';
import { KomenatarAgentService } from '../services/komenatar.service';

@Component({
  selector: 'app-komentar-agent',
  templateUrl: './komentar-agent.component.html',
  styleUrls: ['./komentar-agent.component.css']
})
export class KomentarAgentComponent implements OnInit {

  public vozila: [];
  public vozilo: {
    id: null
  } = null;
  public komentar: string;
  public komentari: [];
  mode: string = 'VIEW';

  constructor(private router: Router, private zauzeceService: zauzeceAutomobilaService, private komentarService: KomenatarAgentService) { }

  ngOnInit(): void {
    this.zauzeceService.getVoziloAgent().subscribe(
      data => {this.vozila = data}
    );
  }

  refresh(){
    this.zauzeceService.getVoziloAgent().subscribe(
      data => {this.vozila = data}
    );
  }

  voziloPromjena(vozilo: any){
      this.komentarService.getKomentari(vozilo.id).subscribe(
        data=> {
          this.komentari =  data;
        }
      );
  }
  onClickDodaj(){
    if(this.mode == 'VIEW'){
      this.mode = 'ADD';
      return;
    }
    
    let newKomenatar  = {
      id: null,
      tekst: this.komentar,
      vozilo: {
        id: this.vozilo.id,
      }
    }

    

    this.komentarService.dodajKomentar(newKomenatar, localStorage.getItem('user-username-key')).subscribe(
      data=>{
        this.refresh();
        
      }
    );
    this.vozilo = null;
        this.komentar = '';
        this.mode = 'VIEW';
        this.komentari = [];
    
    
  }

}
