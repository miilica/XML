import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { TipMjenjaca } from './tipMjenjaca';


@Injectable({
    providedIn: 'root'
})
export class TipMjenjacaService{
    _url = 'http://localhost:8099/api/tipmjenjaca/dodaj';
    _url2 = 'http://localhost:8099/api/tipmjenjaca/get';
   

    constructor(private _http: HttpClient) { }

   dodajTipMjenjaca(tip: TipMjenjaca) {
       return  this._http.post<any>(this._url, tip);
    }

    
    getTipoveMjenjaca():Observable<any>{
        return this._http.get<TipMjenjaca[]>(this._url2);
    }
}