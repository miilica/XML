import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { MarkaAutomobila } from './markaAutomobila';


@Injectable({
    providedIn: 'root'
})
export class DodajMarkuAutomobilaService{
    _url = 'http://localhost:8080/api/';
    _url2 = 'http://localhost:8080/api/';
   

    constructor(private _http: HttpClient) { }

   dodajMarku(marka: MarkaAutomobila) {
       return  this._http.post<any>(this._url, marka);
    }

    
    getMarke():Observable<any>{
        return this._http.get<MarkaAutomobila[]>(this._url2);
    }
}