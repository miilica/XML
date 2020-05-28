package com.example.demo.dto;

import com.example.demo.model.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class VoziloDTO {

    private Long id;
    private double kilomtetraza;
    private double cijena;
    private double ocjena;
    private MarkaAutomobila markaAutomobila;
    private VrstaGoriva gorivo;
    private double mozePreciKM;
    private int brSjedistazaDjecu;
    private TipMjenjaca tipMjenjaca;
    private Boolean imaAndroid;
    private KlasaAutomobila klasaAutomobila;

    public VoziloDTO() {

    }

    public VoziloDTO(Vozilo vozilo) {
        id = vozilo.getId();
        kilomtetraza = vozilo.getKilometraza();
        ocjena = vozilo.getOcjena();
        cijena = vozilo.getCijena();
        markaAutomobila = vozilo.getMarkaAutomobila();
        gorivo = vozilo.getVrstaGoriva();
        mozePreciKM = vozilo.getMozePreciKM();
        brSjedistazaDjecu = vozilo.getBrSjedistazaDjecu();
        tipMjenjaca = vozilo.getTipMjenjaca();
        imaAndroid = vozilo.getImaAndroid();
        klasaAutomobila = vozilo.getKlasaAutomobila();

    }

    public VoziloDTO(Long id, double kilomtetraza, double cijena, double ocjena, MarkaAutomobila markaAutomobila, VrstaGoriva gorivo, double mozePreciKM, int brSjedistazaDjecu, TipMjenjaca tipMjenjaca, Boolean imaAndroid, KlasaAutomobila klasaAutomobila) {
        this.id = id;
        this.kilomtetraza = kilomtetraza;
        this.cijena = cijena;
        this.ocjena = ocjena;
        this.markaAutomobila = markaAutomobila;
        this.gorivo = gorivo;
        this.mozePreciKM = mozePreciKM;
        this.brSjedistazaDjecu = brSjedistazaDjecu;
        this.tipMjenjaca = tipMjenjaca;
        this.imaAndroid = imaAndroid;
        this.klasaAutomobila = klasaAutomobila;
    }
}
