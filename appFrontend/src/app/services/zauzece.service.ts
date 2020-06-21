import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { GET_ALL_VOZILO_AGENT, VOZILO_ZAUZECE_KREIRAJ_AGENT } from '../config/api-paths';
import { Observable } from 'rxjs';

@Injectable({
    providedIn: 'root'
})

export class zauzeceAutomobilaService {

    private urlVoziloAgent: string = '';

    constructor(private http: HttpClient) { 
    }
    

   getVoziloAgent(): Observable<any> {
        return this.http.get(GET_ALL_VOZILO_AGENT);
    }

    zauzeceAutomobil(zauzece: any): Observable<any> {
        return this.http.post(VOZILO_ZAUZECE_KREIRAJ_AGENT, zauzece);
    }
}