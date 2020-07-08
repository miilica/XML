import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/services/user.service';
import { ToastrService } from 'ngx-toastr';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class AdminHomeComponent implements OnInit {

  categories = [];
  komentari = [];
  categoryName: string = '';

  constructor(private usersService: UserService,
              private toastr: ToastrService,
              private router: Router) { }

  ngOnInit() {
    this.getAll();
    this.getComments();
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

  onClickCjenovnik() : void{
    this.router.navigate(['cjenovnik']);
  }

}
