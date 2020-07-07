import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { GET_ALL_VOZILO_AGENT, VOZILO_ZAUZECE_KREIRAJ_AGENT } from '../config/api-paths';
import { Observable } from 'rxjs';

@Injectable({
    providedIn: 'root'
})

export class KomenatarAgentService {

    private urlKomenatariAuto : string = `http://localhost:8099/api/komentar/getKomentareVozilo`;
    private urlKomentarDodaj : string = `http://localhost:8099/api/komentar/dodaj`;


    constructor(private http: HttpClient) { 
    }
    

   getKomentari(vozilo_id: number): Observable<any> {
        return this.http.get<any>(`${this.urlKomenatariAuto}/${vozilo_id}`, );
    }

    dodajKomentar(komentar: any): Observable<any> {
        return this.http.post(`${this.urlKomentarDodaj}`, komentar);
    }
}