package com.example.demo.dto;

import com.example.demo.model.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class VoziloDTO {

    private Long id;
    private double kilomtetraza;
    private int cjena;
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
        id = getId();
        kilomtetraza = getKilomtetraza();
        cjena = getCjena();
        ocjena = getOcjena();
        markaAutomobila = getMarkaAutomobila();
        gorivo = getGorivo();
        mozePreciKM = getMozePreciKM();
        brSjedistazaDjecu = getBrSjedistazaDjecu();
        tipMjenjaca = getTipMjenjaca();
        imaAndroid = getImaAndroid();
        klasaAutomobila = getKlasaAutomobila();

    }

    public VoziloDTO(Long id, double kilomtetraza, int cjena, double ocjena, MarkaAutomobila markaAutomobila, VrstaGoriva gorivo, double mozePreciKM, int brSjedistazaDjecu, TipMjenjaca tipMjenjaca, Boolean imaAndroid, KlasaAutomobila klasaAutomobila) {
        this.id = id;
        this.kilomtetraza = kilomtetraza;
        this.cjena = cjena;
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
