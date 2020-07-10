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
    private urlGetKomentare : string = `http://localhost:8099/api/komentar`;
    private urlgetOcjena : string = `http://localhost:8099/api/ocena/vozilo`;
    private urlOcjenaDodaj : string = `http://localhost:8099/api/ocena`;
    private urlOdobriKomentar : string = `http://localhost:8099/api/komentar/odobri`;


    constructor(private http: HttpClient) { 
    }
    

   getKomentari(vozilo_id: number): Observable<any> {
        return this.http.get<any>(`${this.urlKomenatariAuto}/${vozilo_id}`, );
    }

    dodajKomentar(komentar: any, username: string): Observable<any> {
        return this.http.post(`${this.urlKomentarDodaj}/${username}`, komentar);
    }

    odobriKomentar(flag: any, id: number): Observable<any> {
        return this.http.get<any>(`${this.urlOdobriKomentar}/${flag}/${id}`);
    }

    getKomentare(): Observable<any> {
        return this.http.get<any>(`${this.urlGetKomentare}`);
    }

    dodajOcjenu(ocjena: any): Observable<any> {
        return this.http.post(`${this.urlOcjenaDodaj}`, ocjena);
    }

    getOcjene(vozilo_id: number): Observable<any> {
        return this.http.get<any>(`${this.urlgetOcjena}/${vozilo_id}`, );
    }
}