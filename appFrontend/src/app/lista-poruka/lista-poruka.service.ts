import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Poruka } from '../poruka/poruka';
@Injectable({
    providedIn: 'root'
})
export class ListaPorukaService{
    _url = 'http://localhost:8099/api/poruke';
    
   

    constructor(private _http: HttpClient) { }

    getMojePoruke(Id:number):Observable<any>{
        console.log('juhuu'+Id)
        return this._http.get<Poruka[]>(`${this._url}/${Id}`);
    }
 
 
}