import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { USER_ALL_ADS_URL, USER_ALL_VEHICLES_URL, VEHICLE_TO_CART_URL, ALL_VEHICLEs_IN_CART_URL } from '../config/api-paths';
import VehicleDTO from '../components/models/vehicle-dto.model';


@Injectable({
    providedIn: 'root'
})

export class AdsService {


    constructor(private http: HttpClient) { 
    }
    
    getAllAds(): Observable<any> {
        return this.http.get(USER_ALL_ADS_URL);
    }

    getAllVehicles(): Observable<any> {
        return this.http.get(USER_ALL_VEHICLES_URL);
    }

    addVehicleToCart(vehicle: VehicleDTO): Observable<any> {
        console.log(vehicle);
        return this.http.post(VEHICLE_TO_CART_URL, vehicle);
    }

    getAllVehiclesFromCart(): Observable<any> {
        return this.http.get(ALL_VEHICLEs_IN_CART_URL);
    }

}