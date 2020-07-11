import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { MarkaAutomobila } from './markaAutomobila';


@Injectable({
    providedIn: 'root'
})
export class DodajMarkuAutomobilaService{
    _url = 'http://localhost:8088/api/marka/dodaj';
    //_url2 = 'http://localhost:8099/api/marka';
    _url2 = 'http://localhost:8088/api/marka/get';
    _url3 = 'http://localhost:8088/api/marka/edit';
    _url4 = 'http://localhost:8088/api/marka/delete';
   

    constructor(private _http: HttpClient) { }

   dodajMarku(marka: MarkaAutomobila) {
       return  this._http.post<any>(this._url, marka);
    }

    
    getMarke():Observable<any>{
        return this._http.get<MarkaAutomobila[]>(this._url2);
    }

    editMarku(marka: MarkaAutomobila){
        return this._http.put<MarkaAutomobila>(this._url3, marka);
    }

    deleteMarku(id: number){
        return this._http.delete<MarkaAutomobila>(`${this._url4}/${id}`);
    }
    
}