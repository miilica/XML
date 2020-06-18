import { OnInit, Component } from '@angular/core';
import { ZAHTJEVI_ZA_VOZILA_URL } from 'src/app/config/api-paths';
import { Router } from '@angular/router';
import { ZAHTJEVI_ZA_VOZILA_AGENT_PATH, TERMINI_IZNAJMLJENIH_ZA_VOZILA_AGENT_PATH } from 'src/app/config/router-paths';

@Component({
    selector: 'app-agent-homepage',
    templateUrl: './agent-homepage.component.html',
  })
  export class AgentHomepage implements OnInit {

    ngOnInit(): void {
    }

    constructor(private router: Router) {

    }

    onClickZahtjevi(): void {
        this.router.navigate([ZAHTJEVI_ZA_VOZILA_AGENT_PATH]);
    }

    onClickTermini(): void {
      this.router.navigate([TERMINI_IZNAJMLJENIH_ZA_VOZILA_AGENT_PATH]);
  }

  }
  