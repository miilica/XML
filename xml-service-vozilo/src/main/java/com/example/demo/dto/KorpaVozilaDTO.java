package com.example.demo.dto;

import com.example.demo.model.Agent;
import com.example.demo.model.KorpaVozila;
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

    private MarkaAutomobilaDTO markaAutomobila;

    private KlasaAutomobilaDTO klasaAutomobila;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getCijena() {
        return cijena;
    }

    public void setCijena(double cijena) {
        this.cijena = cijena;
    }

    public double getKilometraza() {
        return kilometraza;
    }

    public void setKilometraza(double kilometraza) {
        this.kilometraza = kilometraza;
    }

    public double getMozePreciKM() {
        return mozePreciKM;
    }

    public void setMozePreciKM(double mozePreciKM) {
        this.mozePreciKM = mozePreciKM;
    }

    public int getBrSjedistaZaDjecu() {
        return brSjedistaZaDjecu;
    }

    public void setBrSjedistaZaDjecu(int brSjedistaZaDjecu) {
        this.brSjedistaZaDjecu = brSjedistaZaDjecu;
    }

    public double getOcjena() {
        return ocjena;
    }

    public void setOcjena(double ocjena) {
        this.ocjena = ocjena;
    }

    public Boolean getImaAndroid() {
        return imaAndroid;
    }

    public void setImaAndroid(Boolean imaAndroid) {
        this.imaAndroid = imaAndroid;
    }

    public boolean isColiisionDamageWavier() {
        return coliisionDamageWavier;
    }

    public void setColiisionDamageWavier(boolean coliisionDamageWavier) {
        this.coliisionDamageWavier = coliisionDamageWavier;
    }

    public boolean isBundle() {
        return bundle;
    }

    public void setBundle(boolean bundle) {
        this.bundle = bundle;
    }

    public MarkaAutomobilaDTO getMarkaAutomobila() {
        return markaAutomobila;
    }

    public void setMarkaAutomobila(MarkaAutomobilaDTO markaAutomobila) {
        this.markaAutomobila = markaAutomobila;
    }

    public KlasaAutomobilaDTO getKlasaAutomobila() {
        return klasaAutomobila;
    }

    public void setKlasaAutomobila(KlasaAutomobilaDTO klasaAutomobila) {
        this.klasaAutomobila = klasaAutomobila;
    }

    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }

    public Long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Long vehicleId) {
        this.vehicleId = vehicleId;
    }
}
