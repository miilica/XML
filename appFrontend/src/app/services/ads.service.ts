import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { USER_ALL_ADS_URL, USER_ALL_VEHICLES_URL, VEHICLE_TO_CART_URL, ALL_VEHICLEs_IN_CART_URL, RENT_A_CAR_REQUEST_URL, ZAHTJEVI_ZA_VOZILA_URL, VEHICLE_STATUS_TO_RESERVED_URL, VEHICLE_STATUS_TO_CANCELED_URL, FIND_VEHICLE_BY_ID_URL, PAY_FOR_RENT_A_CAR_REQUEST_URL } from '../config/api-paths';
import VehicleDTO from '../components/models/vehicle-dto.model';
import ZahtjevDTO from '../components/models/zahtjev-dto.model';


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

    rentACarRequest(vehicle: VehicleDTO): Observable<any> {
        console.log(vehicle);
        return this.http.post(RENT_A_CAR_REQUEST_URL, vehicle);
    }

    getAllZahtjevi(): Observable<any> {
        return this.http.get(ZAHTJEVI_ZA_VOZILA_URL);
    }

    vehicleStatusToReserved(zahtjev: ZahtjevDTO): Observable<any> {
        console.log(zahtjev);
        return this.http.post(VEHICLE_STATUS_TO_RESERVED_URL, zahtjev);
    }

    vehicleStatusToCanceled(zahtjev: ZahtjevDTO): Observable<any> {
        console.log(zahtjev);
        return this.http.post(VEHICLE_STATUS_TO_CANCELED_URL, zahtjev);
    }

    findVehicleById(voziloId:number, agentId:number): Observable<any> {
        return this.http.get<VehicleDTO>(`${FIND_VEHICLE_BY_ID_URL}/${voziloId}/${agentId}`);
    }

    payForRent(zahtjev: ZahtjevDTO): Observable<any> {
        console.log(zahtjev);
        return this.http.post(PAY_FOR_RENT_A_CAR_REQUEST_URL, zahtjev);
    }

}