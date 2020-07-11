import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
    providedIn: 'root'
})

export class VoziloService {

    private urlGetOneOglas : string = `http://localhost:8099/api/oglasi/`;

    constructor(private http: HttpClient) { 
    }
    

   getOneOglas(id: number): Observable<any> {
        return this.http.get<any>(`${this.urlGetOneOglas}`+ id);
    }
}