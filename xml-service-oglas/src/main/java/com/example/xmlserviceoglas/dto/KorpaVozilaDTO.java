package com.example.xmlserviceoglas.dto;

import com.example.xmlserviceoglas.model.KorpaVozila;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class KorpaVozilaDTO {

    private Long id;
    private double cijena;
    private double kilometraza;
    private double mozePreciKM;
    private int brSjedistaZaDjecu;
    private double ocjena;
    private Boolean imaAndroid;
    private boolean coliisionDamageWavier;
    private boolean bundle;
    private MarkaAutomobilaDTO markaAutomobila;
    private KlasaAutomobilaDTO klasaAutomobila;
    private AgentDTO agent;
    private Long vehicleId;

    public KorpaVozilaDTO(KorpaVozila v) {
        this.id = v.getId();
        this.cijena = v.getCijena();
        this.kilometraza = v.getKilometraza();
        this.mozePreciKM = v.getMozePreciKM();
        this.agent = new AgentDTO(v.getAgent());
        this.brSjedistaZaDjecu = v.getBrSjedistaZaDjecu();
        this.imaAndroid = v.getImaAndroid();
        this.coliisionDamageWavier = v.isColiisionDamageWavier();
        this.bundle = v.isBundle();
        this.vehicleId = v.getVehicleId();
    }

}
