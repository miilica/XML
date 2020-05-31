import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/services/user.service';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class AdminHomeComponent implements OnInit {

  categories = [];
  categoryName: string = '';

  constructor(private usersService: UserService,
              private toastr: ToastrService) { }

  ngOnInit() {
    this.getAll();
  }

  private getAll(): void {
    this.usersService.getAllKorisnike().subscribe(data => {
      this.categories = data;
    }, error => {
      this.toastr.error('There was an error while getting the product categories');
    });
  }

  onClickDelete(id: number): void {
    this.usersService.delete(id).subscribe(data => {
      this.toastr.success('Category has been deleted');
      this.getAll();
    }, error => {
      this.toastr.error(error.error.message);
    });
  }
}
