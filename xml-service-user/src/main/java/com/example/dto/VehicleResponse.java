package com.example.dto;

import lombok.Data;

@Data
public class VehicleResponse {

    private Long id;
    private long userAd;
    private long agentAd;
    private String availableFrom;
    private String availableTo;

    public VehicleResponse(Long id, long userAd, long agentAd, String availableFrom, String availableTo) {
        this.id = id;
        this.userAd = userAd;
        this.agentAd = agentAd;
        this.availableFrom = availableFrom;
        this.availableTo = availableTo;
    }
}
