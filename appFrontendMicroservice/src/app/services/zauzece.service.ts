import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
    providedIn: 'root'
})

export class zauzeceAutomobilaService {

    private urlGetVozilo: string = `http://localhost:8086/api/zauzece/getVozilaAgent`;
    private urlDodajZauzece: string = `http://localhost:8086/api/zauzece/dodaj`;


    constructor(private http: HttpClient) { 
    }
    

   getVoziloAgent(): Observable<any> {
        return this.http.get(this.urlGetVozilo);
    }

    zauzeceAutomobil(zauzece: any): Observable<any> {
        return this.http.post(this.urlDodajZauzece, zauzece);
    }
}