import { OnInit, Component } from '@angular/core';
import { Router } from '@angular/router';
import { PORUKE_HOME_PAGE } from 'src/app/config/api-paths';
import { ZAHTJEVI_ZA_VOZILA_AGENT_PATH, AGENT_ZAUZECE, TERMINI_IZNAJMLJENIH_ZA_VOZILA_AGENT_PATH, KOMENTARI_AGENT } from 'src/app/config/router-paths';

@Component({
    selector: 'app-agent-homepage',
    templateUrl: './agent-homepage.component.html',
  })
  export class AgentHomepage implements OnInit {

    ngOnInit(): void {
    }

    constructor(private router: Router) {

    }

    onClickPoruke() : void{
      this.router.navigate([PORUKE_HOME_PAGE]);
    }

    onClickZahtjevi(): void {
        this.router.navigate([ZAHTJEVI_ZA_VOZILA_AGENT_PATH]);
    }

    onClickZauzece() : void{
      this.router.navigate([AGENT_ZAUZECE]);
    }
    onClickTermini(): void {
      this.router.navigate([TERMINI_IZNAJMLJENIH_ZA_VOZILA_AGENT_PATH]);
  }

  onClickKomentarAgent() : void{
    this.router.navigate([KOMENTARI_AGENT]);
  }

  }
  