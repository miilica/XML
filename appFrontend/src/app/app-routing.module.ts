import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import {LoginComponent} from '../app/components/login/login.component';
import {WelcomeComponent} from '../app/components/welcome/welcome.component'
import { AddCarComponent } from './components/dodajVozilo/addCar.component';
import { AddMarkaAutomobila } from './components/dodajMarkaAutomobila/addMarkaAutomobila.component';
import { DodajKlasuAutomobila } from './components/dodajKlasaAutomobila/dodajKlasuAutomobila.component';
import { ADMIN_HOME_PATH, HOME_PATH, LOGIN_PATH, REGISTRATION_PATH, KORISNIK_HOME_PATH, KORPA_KORISNIKA, AGENT_HOME_PATH, ZAHTJEVI_ZA_VOZILA_AGENT_PATH, OCENI_KOMENTARISI_KORISNIK_PATH, TERMINI_IZNAJMLJENIH_ZA_VOZILA_AGENT_PATH } from './config/router-paths';
import { SignupComponent } from './components/signup/signup.component';
import { AdminHomeComponent } from './modules/admin/components/home/home.component';
import { VehicleListComponent } from './modules/korisnik/components/home/vehicle-list.component';
import { KorpaKorisnikaComponent } from './modules/korisnik/components/korpaKorisnika/korpa-korisnika.component';
import { AddTipGoriva } from './components/tipGoriva/tipGoriva.component';
import { DodajTipMjenjaca } from './components/tipMjenjaca/tipMjenjaca.component';
import { AgentHomepage } from './modules/agent/components/home/agent-homepage.component';
import { AgentZahtjevi } from './modules/agent/components/ListaZahtjeva/agent-zahtjevi.component';
import { OceniKomentarisiComponent } from './modules/korisnik/components/oceniKomentarisi/oceniKomentarisi.component';
import { AgentTermini } from './modules/agent/components/listaTermina/agent-termini.component';
import { ZauzeceComponent } from './zauzece/zauzece.component';
import { PorukaComponent } from './poruka/poruka.component';
import { ListaPorukaComponent } from './lista-poruka/lista-poruka.component';
import { Poruka } from './poruka/poruka';
import { DodajOglasComponent } from './components/dodajOglas/dodajOglas.component';

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
  {
    path: KORISNIK_HOME_PATH,
    component: VehicleListComponent
  },
  {
    path: KORPA_KORISNIKA,
    component: KorpaKorisnikaComponent
  },
  {
    path: AGENT_HOME_PATH,
    component: AgentHomepage
  },
  {
    path: ZAHTJEVI_ZA_VOZILA_AGENT_PATH,
    component: AgentZahtjevi
  },
  {
    path: OCENI_KOMENTARISI_KORISNIK_PATH,
    component: OceniKomentarisiComponent
  },
  {
    path: TERMINI_IZNAJMLJENIH_ZA_VOZILA_AGENT_PATH,
    component: AgentTermini
  },
  { path: 'admin/addcar', component: AddCarComponent },
  { path: 'admin/addmarkuautomobila', component: AddMarkaAutomobila },
  { path: 'admin/addklasu', component: DodajKlasuAutomobila },
  { path: 'admin/addtipgoriva', component: AddTipGoriva },
  { path: 'admin/addtipmjenjaca', component: DodajTipMjenjaca },
  { path: 'zauzece', component: ZauzeceComponent},
  { path: 'agent/poruke', component: PorukaComponent},
  { path: 'agent/listaporuka', component: ListaPorukaComponent},
  { path: 'agent/listaporuka/poruke', component: PorukaComponent},
  { path: 'agent/dodajOglas', component: DodajOglasComponent},
  { path: 'korisnik/poruke', component: PorukaComponent},
  { path: 'korisnik/listaporuka', component: ListaPorukaComponent},
  { path: 'korisnik/listaporuka/poruke', component: PorukaComponent},
  { path: 'korisnik/dodajOglas', component: DodajOglasComponent},
  //{ path: 'zauzece', component: ZauzeceComponent},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
