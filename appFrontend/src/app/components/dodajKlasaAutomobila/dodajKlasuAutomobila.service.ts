import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { KlasaAutomobila } from './klasaAutomobila';
import { Observable } from 'rxjs';


@Injectable({
    providedIn: 'root'
})
export class DodajKlasuAutomobilaService{
    _url = 'http://localhost:8080/api/klasa/dodaj';
    _url2 = 'http://localhost:8080/api/klasa/get';
   

    constructor(private _http: HttpClient) { }

   dodajKlasu(klasa: KlasaAutomobila) {
       return  this._http.post<any>(this._url, klasa);
    }

    
    getKlase():Observable<any> {
        return this._http.get<KlasaAutomobila[]>(this._url2);
    }
}