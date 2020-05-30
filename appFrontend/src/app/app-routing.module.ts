import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import {LoginComponent} from '../app/components/login/login.component';
import {WelcomeComponent} from '../app/components/welcome/welcome.component'
import { AddCarComponent } from './components/dodajVozilo/addCar.component';
import { AddMarkaAutomobila } from './components/dodajMarkaAutomobila/addMarkaAutomobila.component';
import { DodajKlasuAutomobila } from './components/dodajKlasaAutomobila/dodajKlasuAutomobila.component';



const routes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: 'welcome', component: WelcomeComponent },
  { path: 'addcar', component: AddCarComponent },
  { path: 'addmarkuautomobila', component: AddMarkaAutomobila },
  { path: 'addklasu', component: DodajKlasuAutomobila },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
