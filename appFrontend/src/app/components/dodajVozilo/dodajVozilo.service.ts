import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Vozilo } from './vozilo';



@Injectable({
    providedIn: 'root'
})
export class DodajVoziloService{
    _url = 'http://localhost:8080/api/vozilo/dodaj';
    _url2 = 'http://localhost:8080/api/vozilo/get';
   

    constructor(private _http: HttpClient) { }

   dodajVozilo(vozilo: Vozilo) {
       return  this._http.post<any>(this._url, vozilo);
    }

    
    getVozila():Observable<any>{
        return this._http.get<Vozilo[]>(this._url2);
    }
}