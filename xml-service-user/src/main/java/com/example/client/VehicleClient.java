package com.example.client;

import com.example.dto.VehicleResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "vehicle")
public interface VehicleClient {

    @GetMapping("")
    VehicleResponse getVehicle(@PathVariable("id") long id);
}
