import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Pretraga } from './pretraga';

@Injectable({
  providedIn: 'root'
})
export class SearchService {

  private urlGetMarke : string = `http://localhost:8099/api/marka`;
  private urlGetMarkeModel : string = `http://localhost:8099/api/marka/models`;
  private urlGetMjenjaci : string = `http://localhost:8099/api/tipmjenjaca`;
  private urlGetGorivo : string = `http://localhost:8099/api/tipgoriva`;
  private urlGetKlase : string = `http://localhost:8099/api/klasa`;
  private urlGetMjestaPreuzimanja: string = `http://localhost:8099/api/oglasi/mjesta`;
  private urlPretraziOglase: string = `http://localhost:8099/api/oglasi/pretraga`;


  constructor(private http: HttpClient) { }

  
  getMarke(): Observable<any> {
    return this.http.get<any>(`${this.urlGetMarke}`);
  }

  getMjenjaci(): Observable<any> {
    return this.http.get<any>(`${this.urlGetMjenjaci}`);
  }

  getGoriva(): Observable<any> {
    return this.http.get<any>(`${this.urlGetGorivo}`);
  }

  getKlaseAuta(): Observable<any> {
    return this.http.get<any>(`${this.urlGetKlase}`);
  }

  getMjestaPreuzimanja(): Observable<any> {
    return this.http.get<any>(`${this.urlGetMjestaPreuzimanja}`);
  }

  getModeli(id: number): Observable<any> {
    return this.http.get<any>(`${this.urlGetMarkeModel}/${id}`);
  }

  pretraziOglase(pretraga: Pretraga, page: number, sort: string): Observable<any>  {
    return this.http.post(`${this.urlPretraziOglase}/${page}/${sort}`, pretraga);
  }

}
