import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {RouterModule} from '@angular/router'

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { MatSliderModule } from '@angular/material/slider';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatButtonModule} from '@angular/material/button';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatInputModule} from '@angular/material/input';

import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { ToastrModule } from 'ngx-toastr';

import { HeaderComponent } from './components/header/header.component';
import { FooterComponent } from './components/footer/footer.component';
import { LoginComponent } from './components/login/login.component';
import { SignupComponent } from './components/signup/signup.component';
import { WelcomeComponent } from './components/welcome/welcome.component';
import { AddCarComponent } from './components/dodajVozilo/addCar.component';
import { AddMarkaAutomobila } from './components/dodajMarkaAutomobila/addMarkaAutomobila.component';
import { KlasaAutomobila } from './components/dodajKlasaAutomobila/klasaAutomobila';
import { DodajKlasuAutomobila } from './components/dodajKlasaAutomobila/dodajKlasuAutomobila.component';
import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';
import { AddTokenInterceptor } from './interceptors/http-interceptor';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AdminHomeComponent } from './modules/admin/components/home/home.component';
import {MatIconModule} from '@angular/material/icon';
import { VehicleListComponent } from './modules/korisnik/components/home/vehicle-list.component';
import { KorpaKorisnikaComponent } from './modules/korisnik/components/korpaKorisnika/korpa-korisnika.component';
import { AddTipGoriva } from './components/tipGoriva/tipGoriva.component';
import { DodajTipMjenjaca } from './components/tipMjenjaca/tipMjenjaca.component';
import { AgentHomepage } from './modules/agent/components/home/agent-homepage.component';
import { AgentZahtjevi } from './modules/agent/components/ListaZahtjeva/agent-zahtjevi.component';
import {MatCheckboxModule} from '@angular/material/checkbox';
import { OceniKomentarisiComponent } from './modules/korisnik/components/oceniKomentarisi/oceniKomentarisi.component';


@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    LoginComponent,
    SignupComponent,
    WelcomeComponent,
    AdminHomeComponent,
    AddCarComponent,
    AddMarkaAutomobila,
    DodajKlasuAutomobila,
    VehicleListComponent,
    KorpaKorisnikaComponent,
    AddTipGoriva,
    DodajTipMjenjaca,
    AgentHomepage,
    AgentZahtjevi,
    OceniKomentarisiComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatSliderModule,
    MatToolbarModule,
    MatButtonModule,
    MatFormFieldModule,
    MatInputModule,
    NgbModule,
    RouterModule,
    HttpClientModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule,
    ToastrModule.forRoot(),
    MatIconModule,
    MatCheckboxModule,
  ],
  providers: [
    { provide: HTTP_INTERCEPTORS, useClass: AddTokenInterceptor, multi: true },
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
