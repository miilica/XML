package com.example.demo.dto;

import com.example.demo.model.Agent;
import com.example.demo.model.KlasaAutomobila;
import com.example.demo.model.KorpaVozila;
import com.example.demo.model.MarkaAutomobila;
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

    private  boolean bundle;

    private MarkaAutomobila markaAutomobila;

    private KlasaAutomobila klasaAutomobila;

    private Agent agent;

    private Long vehicleId;

/*
    private Set<TerminIznajmljivanja> terminiIznajmljivanja;

    private Set<Komentar> komentari;

    private Set<Izvjestaj> izvjestaji;

    private Set<Oglas> oglasi;
*/

    public KorpaVozilaDTO(KorpaVozila v) {
        this.id = v.getId();
        this.cijena = v.getCijena();
        this.kilometraza = v.getKilometraza();
        this.mozePreciKM = v.getMozePreciKM();
        this.agent = v.getAgent();
        this.brSjedistaZaDjecu = v.getBrSjedistaZaDjecu();
        this.imaAndroid = v.getImaAndroid();
        this.coliisionDamageWavier = v.isColiisionDamageWavier();
        this.bundle = v.isBundle();
        this.vehicleId = v.getVehicleId();
    }

}