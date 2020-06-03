import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import {LoginComponent} from '../app/components/login/login.component';
import {WelcomeComponent} from '../app/components/welcome/welcome.component'
import { AddCarComponent } from './components/dodajVozilo/addCar.component';
import { AddMarkaAutomobila } from './components/dodajMarkaAutomobila/addMarkaAutomobila.component';
import { DodajKlasuAutomobila } from './components/dodajKlasaAutomobila/dodajKlasuAutomobila.component';
import { ADMIN_HOME_PATH, HOME_PATH, LOGIN_PATH, REGISTRATION_PATH, VERIFY_ACCOUNT } from './config/router-paths';
import { SignupComponent } from './components/signup/signup.component';
import { AdminHomeComponent } from './modules/admin/components/home/home.component';


const routes: Routes = [
  {
    path: HOME_PATH,
    component: WelcomeComponent
  },
  {
    path: LOGIN_PATH,
    component: LoginComponent
  },
  {
    path: REGISTRATION_PATH,
    component: SignupComponent
  },
  {
    path: ADMIN_HOME_PATH,
    component: AdminHomeComponent
  },
  { path: 'admin/addcar', component: AddCarComponent },
  { path: 'admin/addmarkuautomobila', component: AddMarkaAutomobila },
  { path: 'admin/addklasu', component: DodajKlasuAutomobila },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
