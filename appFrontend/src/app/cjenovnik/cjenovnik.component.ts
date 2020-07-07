import { Component, OnInit } from '@angular/core';
import { Route } from '@angular/compiler/src/core';
import { Router, ActivatedRoute } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { CjenovnikService } from './cjenovnik.service';
import { Cjenovnik } from '../search/shared/cjenovnik';

@Component({
  selector: 'app-cjenovnik',
  templateUrl: './cjenovnik.component.html',
  styleUrls: ['./cjenovnik.component.css']
})
export class CjenovnikComponent implements OnInit {

  modal: NgbModalRef;
  cjenovnik: Cjenovnik;
  cjenovnici: Cjenovnik[];
  role: string='';
  username: string='';
  mode: string = 'ADD';
  

  constructor(private router: Router, private toaster: ToastrService,
    private route: ActivatedRoute, private ngbModal: NgbModal,
    private cjenovnikService: CjenovnikService) { 
        this.cjenovnik = {
          cijenaPoDanu:0,
          cijenaPoKM:0,
          cijenaCDW:0,
          popust:0,
          id:null,
          userUsername: localStorage.getItem('user-username-key')
        }
    }

  ngOnInit(): void {

    this.username = localStorage.getItem('user-username-key');
    this.role = localStorage.getItem('user-role-key');

    this.cjenovnikService.getCjenovnik(this.username).subscribe(
      data => {
        this.cjenovnici = data;
      },
      error => {
        this.toaster.error('Greska prilikom dobavljanja cjenovnika');
      }
    );
  }


  dodajCjenovnik(sadrzaj: any){
    this.clear();
    //this.refresh();
    this.mode = 'ADD';
    this.modal = this.ngbModal.open(sadrzaj,{size: 'lg'});
  }

  
  dodaj(){
    if(this.cjenovnik.cijenaPoDanu == 0 || this.cjenovnik.cijenaPoKM == 0 || this.cjenovnik.cijenaCDW == 0 ){
      this.toaster.info("Ispunite polja");
      return;
    }

      this.cjenovnikService.dodajCjenovnik(this.cjenovnik).subscribe(
        data => {
          this.toaster.success("Cjenovnik uspjesno kreiran");
          this.clear();
         // this.refresh();
          this.modal.close();
        },
        error => {
            this.toaster.error("Greska prilikom kreiranja cjenovnika");
        }
      );
  }

  izmjeniCjenovnik(sadrzaj: any, cjenovnik: Cjenovnik){
      this.cjenovnik = cjenovnik;
      this.mode = 'EDIT';
      this.modal = this.ngbModal.open(sadrzaj,{size: 'lg'});
  }

  sacuvaj(){
    if(this.cjenovnik.cijenaPoDanu == 0 || this.cjenovnik.cijenaPoKM == 0 || this.cjenovnik.cijenaCDW == 0 ){
      this.toaster.info("Ispunite polja");
      return;
    }
      this.cjenovnikService.izmjeniCjenovnik(this.cjenovnik).subscribe(
        data => {
          this.toaster.success("Cjenovnik uspjesno kreiran");
          this.clear();
         // this.refresh();
          this.modal.close();
          this.mode = 'ADD';
        },
        error => {
            this.toaster.error("Greska prilikom izmjene cjenovnika");
        }
      )
      
  }

  
  clear(){
    this.cjenovnik.id = null;
    this.cjenovnik.cijenaPoDanu = 0;
    this.cjenovnik.cijenaPoKM = 0;
    this.cjenovnik.cijenaCDW = 0;
    this.cjenovnik.popust = 0;
    this.cjenovnik.userUsername = this.username;
  }

}
