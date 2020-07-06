import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { KlasaAutomobila } from './klasaAutomobila';
import { Observable } from 'rxjs';


@Injectable({
    providedIn: 'root'
})
export class DodajKlasuAutomobilaService{
    _url = 'http://localhost:8099/api/klasa/dodaj';
    _url2 = 'http://localhost:8099/api/klasa/get';
    _url3 = 'http://localhost:8099/api/klasa/edit';
    _url4 = 'http://localhost:8099/api/klasa/delete';

    constructor(private _http: HttpClient) { }

   dodajKlasu(klasa: KlasaAutomobila) {
       return  this._http.post<any>(this._url, klasa);
    }

    
    getKlase():Observable<any> {
        return this._http.get<KlasaAutomobila[]>(this._url2);
    }

    editKlasu(klasa: KlasaAutomobila){
        return this._http.put<KlasaAutomobila>(this._url3, klasa);
    }

    deleteKlasu(id: number){
        return this._http.delete<KlasaAutomobila>(`${this._url4}/${id}`);
    }
   
}