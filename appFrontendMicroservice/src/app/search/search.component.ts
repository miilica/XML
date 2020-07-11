import { Component, OnInit } from '@angular/core';
import { NgbModalRef, NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { ActivatedRoute, Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Marka } from './shared/marka';
import { Mjenjac } from './shared/mjenjac';
import { Klasa } from './shared/klasa';
import { Gorivo } from './shared/gorivo';
import { Pretraga } from './shared/pretraga';
import { OglasInfo } from './shared/oglasinfo';
import { SearchService } from './shared/search.service';
import { VoziloService } from '../services/vozilo.service';
import { KomenatarAgentService } from '../services/komenatar.service';
import { AdsService } from '../services/ads.service';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {

  marke: Marka[] = [];
  modeli: string[];
  mjenjaci: Mjenjac[];
  klase: Klasa[];
  goriva: Gorivo[];
  pretraga: Pretraga;
  oglasi: OglasInfo[] = [];
  role: string = '';
  mjesta: string[];
  pages: number[] = [];
  viewModal: NgbModalRef;
  sortiranje: string = 'Sort by';
  oglas: OglasInfo;
  //komentari: Komentar[];
  
  constructor(
              private route: ActivatedRoute,
              private searchService: SearchService,
              private voziloService: VoziloService,
              private komentarService: KomenatarAgentService,
              private _toastr: ToastrService,
              private router: Router,
              private modalService: NgbModal,
              private adsService: AdsService,
              private toastr: ToastrService) {
    this.pretraga = {
        mjestoPreuzimanja: '',
        od: null,
        doo: null,
        cijenaOd: 0,
        cijenaDo: 0,
        kilometrazaOd: 0,
        kilometrazaDo: 0,
        kilometrazaDozvoljena: 0,
        cdw: false,
        brojDjecijihMjesta: 0,

        klasa : {
          id: null,
          naziv: ''
        },
        gorivo : {
          id: null,
          naziv: ''
        },
        mjenjac : {
          id: null,
          naziv: ''
        },
        marka : {
          id: null,
          nazivMarke: '',
          model: null
        }
    };
   }

  ngOnInit(): void {
    this.getData();
    this.role = localStorage.getItem("User-role");
  }

  getData() {
    this.searchService.getMarke()
      .subscribe((data: Marka[]) => this.marke = data);
    this.searchService.getMjenjaci()
      .subscribe((data: Mjenjac[]) => this.mjenjaci = data);
    this.searchService.getGoriva()
      .subscribe((data: Gorivo[]) => this.goriva = data);
    this.searchService.getKlaseAuta()
      .subscribe((data: Klasa[]) => this.klase = data);
    this.searchService.getMjestaPreuzimanja()
      .subscribe((data: string[]) => this.mjesta = data);
  }

  change(id){
    this.searchService.getModeli(id)
      .subscribe((data: string[]) => this.modeli = data);
  }

  clear(){
    this.pretraga.cdw = false;
    this.pretraga.kilometrazaDozvoljena = 0;
    this.pretraga.kilometrazaOd = 0;
    this.pretraga.kilometrazaDo = 0;
    this.pretraga.brojDjecijihMjesta = 0;
    this.pretraga.cijenaOd= 0;
    this.pretraga.cijenaDo = 0;
    this.pretraga.klasa = {id: null, naziv: ''};
    this.pretraga.gorivo = {id: null, naziv: ''};
    this.pretraga.mjenjac = {id: null, naziv: ''};
    this.pretraga.marka = {id: null, nazivMarke: '', model: null};
    this.pretraga.mjestoPreuzimanja = '';
    this.pretraga.od = null;
    this.pretraga.doo = null;
  }

  clearAdditional(){
    this.pretraga.cdw = false;
    this.pretraga.kilometrazaDozvoljena = 0;
    this.pretraga.kilometrazaOd = 0;
    this.pretraga.kilometrazaDo = 0;
    this.pretraga.brojDjecijihMjesta = 0;
    this.pretraga.cijenaOd= 0;
    this.pretraga.cijenaDo = 0;
    this.pretraga.klasa = {id: null, naziv: ''};
    this.pretraga.gorivo = {id: null, naziv: ''};
    this.pretraga.mjenjac = {id: null, naziv: ''};
    this.pretraga.marka = {id: null, nazivMarke: '', model: null};
  }
  
  pretraziOglase(page: number){
    if(this.pretraga.mjestoPreuzimanja == '' || this.pretraga.od == null || this.pretraga.doo == null){
      this._toastr.info('Molimo popunite sva polja');
      return;
  }

  this.searchService.pretraziOglase(this.pretraga,page,this.sortiranje).subscribe(
    data => {
        this.oglasi = data;
        this.pages = [];
        for (let i = 1; i <= this.oglasi[0].pages; i++) {
          this.pages[i - 1] = i;
        }
        if(this.oglasi.length > 0){
          this._toastr.success('Pretraga uspješno završena');
        }else{
          this._toastr.info('Nema pronađenih rezultata');
        }
    },
    error =>{
      if(error.status == 400){
        this._toastr.info('Datumi nisu validini');
      }else{
        this._toastr.error('Greška tokom pretrage');
      }
    }
  );
  }

  pogledaj(sadrzaj, oglas : OglasInfo){
    
    this.voziloService.getOneOglas(oglas.id).subscribe(
      data => {
        this.oglas = data;
      }
    );

    this.viewModal = this.modalService.open(sadrzaj, {size: 'lg', scrollable: true});
  }

  sortiraj(){
    this.pretraziOglase(0);
  }

  public addToCart(oglas: OglasInfo): void {
    console.log("Oglas: ",oglas);
    this.adsService.addVehicleToCart(oglas.vozilo).subscribe(data => {
      this.toastr.success('Vehicle has been added to cart');
    }, error => {
      this.toastr.error(error.error.message);
    });
  }

}