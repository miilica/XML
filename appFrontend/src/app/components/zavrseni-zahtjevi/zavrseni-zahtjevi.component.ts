import { Component, OnInit } from '@angular/core';
import { AdsService } from 'src/app/services/ads.service';
import { NgbModalRef, NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { KomenatarAgentService } from 'src/app/services/komenatar.service';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-zavrseni-zahtjevi',
  templateUrl: './zavrseni-zahtjevi.component.html',
  styleUrls: ['./zavrseni-zahtjevi.component.css']
})
export class ZavrseniZahtjeviComponent implements OnInit {

  zahtjevi = [];
  textComment: string ='';
  currentRate: number = 0;
  zahtjev = {
    vozilo : {
      id: null
    },
    oglas : {
      id: null
    }
  };
  myModal: NgbModalRef;

  constructor(private adsService: AdsService,
    private modalService: NgbModal, 
    private komentarService: KomenatarAgentService,
    private toaster: ToastrService
    ) { }

  ngOnInit(): void {
    this.adsService.getZavrseniZahtjevi().subscribe(
      data => {
        this.zahtjevi  = data;
      }
    );
  }

  send(){
    if (this.textComment == '' && this.currentRate == 0) {
      this.toaster.info("Popunite polja", "Komentari i ocjene");
      return;
    }

    if(this.textComment != ''){
      let komentar = {
        vozilo: {
          id: this.zahtjev.vozilo.id
        },
        tekst: this.textComment
      };
      let username = localStorage.getItem("user-username-key");
      this.komentarService.dodajKomentar(komentar, username).subscribe(
        data => {
          this.toaster.success("Komentar uspjesno postavljen", "Komentar");
        }
      );
      this.toaster.success("Komentar uspjesno postavljen", "Komentar"); 
    }

    
    if(this.currentRate != 0){
      let ocjena = {
        id: null,
        ocena: this.currentRate,
        userUsername: localStorage.getItem('user-username-key'),
        oglasId: this.zahtjev.oglas.id
      }

      this.komentarService.dodajOcjenu(ocjena).subscribe(
        data => {
          this.toaster.success("Ocjena uspjesno postavljena", "Ocjena");
        }
      );
    }

    this.textComment = '';
    this.currentRate = 0 ;
    this.myModal.close();
  }

  open(prozor, zahtjev){
    this.myModal = this.modalService.open(prozor);
    this.textComment = '';
    this.currentRate = 0 ;
    this.zahtjev = zahtjev;
  }

}
