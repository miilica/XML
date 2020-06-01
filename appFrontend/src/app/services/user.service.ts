import { VERIFY_ACC_URL, REGISTER_URL, ADMIN_ALL_USERS_URL, ADMIN_ALL_KORISNIKE_URL, ADMIN_DELETE_KORISNIKA_URL, ADMIN_ACTIVATE_KORISNIKA_URL } from './../config/api-paths';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import UserRegistrationDTO from '../components/models/user-registration-dto.model';


@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) { 
  }

  verifyAccount(token: string): Observable<any> {
    return this.http.get(`${VERIFY_ACC_URL}/${token}`);
  }

  register(user: UserRegistrationDTO): Observable<any> {
    return this.http.post(REGISTER_URL, user);
  }

  getAll(): Observable<any> {
    return this.http.get(ADMIN_ALL_USERS_URL);
  }

  getAllKorisnike(): Observable<any> {
    return this.http.get(ADMIN_ALL_KORISNIKE_URL);
  }

  delete(id: number): Observable<any> {
    return this.http.delete(`${ADMIN_DELETE_KORISNIKA_URL}/${id}`);
  }

  activate(id: number): Observable<any> {
    return this.http.get(`${ADMIN_ACTIVATE_KORISNIKA_URL}/${id}`);
  }

}
