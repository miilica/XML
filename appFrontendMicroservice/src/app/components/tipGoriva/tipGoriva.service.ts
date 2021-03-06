import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { TipGoriva } from './tipGoriva';


@Injectable({
    providedIn: 'root'
})
export class TipGorivaService{
    _url = 'http://localhost:8088/api/tipgoriva/dodaj';
   // _url2 = 'http://localhost:8099/api/tipgoriva';
    _url2 = 'http://localhost:8088/api/tipgoriva/get';
    _url3 = 'http://localhost:8088/api/tipgoriva/edit';
    _url4 = 'http://localhost:8088/api/tipgoriva/delete';
   

    constructor(private _http: HttpClient) { }

   dodajTipGoriva(tip: TipGoriva) {
       return  this._http.post<any>(this._url, tip);
    }

    
    getTipoveGoriva():Observable<any>{
        return this._http.get<TipGoriva[]>(this._url2);
    }

    editTipGoriva(gorivo: TipGoriva){
        return this._http.put<TipGoriva>(this._url3, gorivo);
    }

    deleteTiGoriva(id: number){
        return this._http.delete<TipGoriva>(`${this._url4}/${id}`);
    }
}