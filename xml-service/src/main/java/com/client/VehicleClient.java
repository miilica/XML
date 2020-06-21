package com.client;

import https.ftn_uns_ac_rs.vehicle.GetVehicleRequest;
import https.ftn_uns_ac_rs.vehicle.TVehicle;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

@Slf4j
public class VehicleClient extends WebServiceGatewaySupport {

    public GetVehicleRequest getVehicle (TVehicle tVozilo) {
        GetVehicleRequest request = new GetVehicleRequest();
        request.setVehicleRequest(tVozilo);

        log.info("Requesting vozilo " + tVozilo);

        GetVehicleRequest response = (GetVehicleRequest) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8089/vehicle-soap/Vehicle", request,
                        new SoapActionCallback("https://ftn.uns.ac.rs/vehicle/getVehicleRequest"));
        return response;

    }
}
