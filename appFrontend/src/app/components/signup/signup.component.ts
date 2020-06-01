import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { AuthService } from 'src/app/services/auth.service';
import { Router } from '@angular/router';
import { UserService } from './../../services/user.service';
import { HOME_PATH } from 'src/app/config/router-paths';
import UserRegistrationDTO from '../models/user-registration-dto.model';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  registrationForm: FormGroup;

  constructor(private userService: UserService,
              private authService: AuthService,
              private fb: FormBuilder,
              private router: Router,
              private toastr: ToastrService) { }

  ngOnInit(): void {
    if (this.authService.isUserLoggedIn()) {
      this.toastr.warning('Please logout if you want to create a new account.', 'Warning');
      this.router.navigate([HOME_PATH]);
    }

    this.createForm();
  }

  private createForm(): void {
    this.registrationForm = this.fb.group({
      name: ['', Validators.required],
      surname: ['', Validators.required],
      username: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      password: ['', Validators.required],
      repeatPassword: ['', Validators.required],
      country: ['', Validators.required],
      address: ['', Validators.required],
      city: ['', Validators.required],
      phone: ['', Validators.required],
    });
  }

  onRegisterSubmit(): void {
    const password = this.registrationForm.controls.password.value;
    const repeatPassword = this.registrationForm.controls.repeatPassword.value;

    if (password !== repeatPassword) {
      this.toastr.warning('Passwords don\'t match', 'Warning');
      return;
    }

    const userInfo: UserRegistrationDTO = {
      username: this.registrationForm.controls.username.value,
      password: password,
      repeatPassword: repeatPassword,
      email: this.registrationForm.controls.email.value,
      name: this.registrationForm.controls.name.value,
      surname: this.registrationForm.controls.surname.value,
      country: this.registrationForm.controls.country.value,
      address: this.registrationForm.controls.address.value,
      city: this.registrationForm.controls.city.value,
      phone: this.registrationForm.controls.phone.value,
    };

    this.userService.register(userInfo).subscribe(data => {
      this.toastr.success('You account has been created, go to your email to verify it.');
    }, error => {
      console.log(userInfo);
      this.toastr.error('There was an error while adding your account. Try again later.');
    });
  }

}
