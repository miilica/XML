import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { TipGoriva } from './tipGoriva';


@Injectable({
    providedIn: 'root'
})
export class TipGorivaService{
    _url = 'http://localhost:8080/api/tipgoriva/dodaj';
    _url2 = 'http://localhost:8080/api/tipgoriva/get';
   

    constructor(private _http: HttpClient) { }

   dodajTipGoriva(tip: TipGoriva) {
       return  this._http.post<any>(this._url, tip);
    }

    
    getTipoveGoriva():Observable<any>{
        return this._http.get<TipGoriva[]>(this._url2);
    }
}