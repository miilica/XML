import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Poruka } from './poruka';





@Injectable({
    providedIn: 'root'
})
export class PorukeService{
    _url = 'http://localhost:8099/api/poruke';
    //_url2 = 'http://localhost:8099/api/poruke/{posiljalacId}/{primalacId}/{oglasId}';
   

    constructor(private _http: HttpClient) { }

   posalji(poruka: Poruka) {
       return  this._http.post<any>(this._url, poruka);
    }

    
   // get():Observable<any>{
    //    return this._http.get<Poruka[]>(this._url2);
    //}
}