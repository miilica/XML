import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/services/user.service';
import { ToastrService } from 'ngx-toastr';
import { DodajMarkuAutomobilaService } from 'src/app/components/dodajMarkaAutomobila/dodajMarkuAutomobila.service';
import { DodajKlasuAutomobilaService } from 'src/app/components/dodajKlasaAutomobila/dodajKlasuAutomobila.service';
import { TipGorivaService } from 'src/app/components/tipGoriva/tipGoriva.service';
import { TipMjenjacaService } from 'src/app/components/tipMjenjaca/tipMjenjaca.service';
import { MarkaAutomobila } from 'src/app/components/dodajMarkaAutomobila/markaAutomobila';
import { Router } from '@angular/router';
import { KlasaAutomobila } from 'src/app/components/dodajKlasaAutomobila/klasaAutomobila';
import { TipGoriva } from 'src/app/components/tipGoriva/tipGoriva';
import { TipMjenjaca } from 'src/app/components/tipMjenjaca/tipMjenjaca';



@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class AdminHomeComponent implements OnInit {

  editModel = new MarkaAutomobila(null,null,null);
  editModelKlasa = new KlasaAutomobila(null, null);
  editModelTipGoriva = new TipGoriva(null, null);
  editModelTipMenjaca = new TipMjenjaca(null, null);
  edit : boolean = false;
  edit1 : boolean = false;
  edit2 : boolean = false;
  edit3 : boolean = false;
  categories = [];
  komentari = [];
  marke = [];
  marka = new MarkaAutomobila(null,null,null);
  public editedMarka:MarkaAutomobila;
  public editedKlasa:KlasaAutomobila;
  public editedTipGoriva:TipGoriva;
  public editedTipMenjaca:TipMjenjaca;
  goriva = [];
  klase = [];
  menjaci = [];
  categoryName: string = '';

  constructor(private usersService: UserService, private dodajMarkuAutomobilaService: DodajMarkuAutomobilaService,private router: Router,
              private tipMenjacaService : TipMjenjacaService,private tipGorivaService : TipGorivaService,private dodajKlasuAutomobilaService : DodajKlasuAutomobilaService ,private toastr: ToastrService) { }

  ngOnInit() {
    this.getAll();
    this.getComments();
    this.getAllMarkaAutomobila();
    this.getAllKlase();
    this.getAllTipGoriva();
    this.getAllTipMenjaca();
  }

  onSubmit1(){
    this.dodajMarkuAutomobilaService.editMarku(this.editModel).subscribe(
        data=>{
            alert('Marka izmenjena!');
            this.editedMarka = data as MarkaAutomobila;
            this.getAllMarkaAutomobila();
            this.router.navigate(['/admin']);
        },
        error=> console.error('Error!', error)
    )
    this.edit = false; 
  }

  onSubmit(){
    this.dodajKlasuAutomobilaService.editKlasu(this.editModelKlasa).subscribe(
        data=>{
            alert('Klasa izmenjena!');
            this.editedKlasa = data as KlasaAutomobila;
            this.getAllKlase();
            this.router.navigate(['/admin']);
        },
        error=> console.error('Error!', error)
    )
    this.edit1 = false; 
  }

  onSubmit2(){
    this.tipGorivaService.editTipGoriva(this.editModelTipGoriva).subscribe(
        data=>{
            alert('Tip goriva izmenjen!');
            this.editedTipGoriva = data as TipGoriva;
            this.getAllTipGoriva();
            this.router.navigate(['/admin']);
        },
        error=> console.error('Error!', error)
    )
    this.edit2 = false; 
  }

  onSubmit3(){
    this.tipMenjacaService.editTipMenjaca(this.editModelTipMenjaca).subscribe(
        data=>{
            alert('Tip menjaca izmenjen!');
            this.editedTipMenjaca = data as TipMjenjaca;
            this.getAllTipMenjaca();
            this.router.navigate(['/admin']);
        },
        error=> console.error('Error!', error)
    )
    this.edit3 = false; 
  }

    editMarku(marka: MarkaAutomobila):void{   
      this.edit = true;
      this.editModel.nazivMarke = marka.nazivMarke;
      this.editModel.model = marka.model;
      this.editModel.id = marka.id;
      
  }

editKlasu(klasa: KlasaAutomobila):void{   
  this.edit1 = true;
  this.editModelKlasa.naziv = klasa.naziv;
  this.editModelKlasa.id = klasa.id;
  
}

deleteKlasu(id):void{
  this.dodajKlasuAutomobilaService.deleteKlasu(id).subscribe(
    data=>{
      alert('Obrisana klasa automobila!');
      
  },
  error=> console.error('Error!', error)
  )
}

deleteMarku(id):void{
  this.dodajMarkuAutomobilaService.deleteMarku(id).subscribe(
    data=>{
      alert('Obrisana marka autmobila!');
      
  },
  error=> console.error('Error!', error)
  )
}

deleteTipMenjaca(id):void{
  this.tipMenjacaService.deleteTipMenjaca(id).subscribe(
    data=>{
      alert('Obrisan tip menjaca!');
      
  },
  error=> console.error('Error!', error)
  )
}

editTipGoriva(gorivo: TipGoriva):void{   
  this.edit2 = true;
  this.editModelTipGoriva.naziv = gorivo.naziv;
  this.editModelTipGoriva.id = gorivo.id;
  
}

editTipMenjaca(menjac: TipMjenjaca):void{   
  this.edit3 = true;
  this.editModelTipMenjaca.naziv = menjac.naziv;
  this.editModelTipMenjaca.id = menjac.id;
  
}

  private getAllMarkaAutomobila(): void{
    this.dodajMarkuAutomobilaService.getMarke().subscribe(data => {
      this.marke = data;
    },error => {
      this.toastr.error('Greska prilikom dobavljanja marki automobila');
    });
  }

  private getAllKlase(): void{
    this.dodajKlasuAutomobilaService.getKlase().subscribe(data => {
      this.klase = data;
    },error => {
      this.toastr.error('Greska prilikom dobavljanja klasi automobila');
    });
  }

  private getAllTipGoriva(): void{
    this.tipGorivaService.getTipoveGoriva().subscribe(data => {
      this.goriva = data;
    },error => {
      this.toastr.error('Greska prilikom dobavljanja tipova goriva');
    });
  }

  private getAllTipMenjaca(): void{
    this.tipMenjacaService.getTipoveMjenjaca().subscribe(data => {
      this.menjaci = data;
    },error => {
      this.toastr.error('Greska prilikom dobavljanja tipova menjaca');
    });
  }

  private getAll(): void {
    this.usersService.getAllKorisnike().subscribe(data => {
      this.categories = data;
    }, error => {
      this.toastr.error('There was an error while getting the product categories');
    });
  }

  private getComments(): void {
    this.usersService.getAllComments().subscribe(data => {
      this.komentari = data;
      console.log("Svi komentari: ",this.komentari);
    }, error => {
      this.toastr.error('There was an error while getting comments');
    });
  }

  onClickDelete(id: number): void {
    this.usersService.delete(id).subscribe(data => {
      this.toastr.success('User has been deleted');
      this.getAll();
    }, error => {
      this.toastr.error(error.error.message);
    });
  }

  onClickActivate(id: number): void {
    this.usersService.activate(id).subscribe(data => {
      this.toastr.success('User has been activated/deactivated');
      this.getAll();
    }, error => {
      this.toastr.error(error.error.message);
    });
  }

  onClickActivateComment(id: number): void {
    this.usersService.activateComment(id).subscribe(data => {
      this.toastr.success('Comment has been activated/deactivated');
      this.getComments();
    }, error => {
      this.toastr.error(error.error.message);
    });
  }

}
