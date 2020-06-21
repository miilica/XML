import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { GET_ALL_VOZILO_AGENT } from '../config/api-paths';
import { Observable } from 'rxjs';

@Injectable({
    providedIn: 'root'
})

export class zauzeceAutomobilaService {

    private urlVoziloAgent: string = '';

    constructor(private http: HttpClient) { 
    }
    

   getVoziloAgent(): Observable<any> {
        return this.http.get(GET_ALL_VOZILO_AGENT);
    }

}