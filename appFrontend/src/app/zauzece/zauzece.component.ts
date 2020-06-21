import { OnInit, Component } from '@angular/core';
import { Router } from '@angular/router';
import { zauzeceAutomobilaService } from '../services/zauzece.service';

@Component({
    selector: 'app-zauzece',
    templateUrl: './zauzece.component.html',
    styleUrls: ['zauzece.component.css']
  })
  export class ZauzeceComponent implements OnInit {

    public vozila: [];
    vozilo: {};

    public datumOd: "";
    public datumDo: "";

    
    constructor(private router: Router, private zauzeceService: zauzeceAutomobilaService) {

    }

    ngOnInit(): void {
      this.zauzeceService.getVoziloAgent().subscribe(
        data => {this.vozila = data}
      );
    }

  }
  