package com.dto;

public class VoziloDTO {

    private Long id;
    private double cijena;
    private double kilometraza;
    private double mozePreciKM;
    private int brSjedistaZaDjecu;
    private double ocjena;
    private MarkaAutomobilaDTO markaAutomobila;
    private VrstaGorivaDTO tipGoriva;
    private TipMjenjacaDTO tipMjenjaca;
    private KlasaAutomobilaDTO klasaAutomobila;
    private Boolean imaAndroid;
    private boolean coliisionDamageWavier;

    public VoziloDTO() {

    }

    public VoziloDTO(Long id, double cijena, double kilometraza, double mozePreciKM, int brSjedistaZaDjecu, double ocjena, MarkaAutomobilaDTO markaAutomobila, VrstaGorivaDTO tipGoriva, TipMjenjacaDTO tipMjenjaca, KlasaAutomobilaDTO klasaAutomobila, Boolean imaAndroid, boolean coliisionDamageWavier) {
        this.id = id;
        this.cijena = cijena;
        this.kilometraza = kilometraza;
        this.mozePreciKM = mozePreciKM;
        this.brSjedistaZaDjecu = brSjedistaZaDjecu;
        this.ocjena = ocjena;
        this.markaAutomobila = markaAutomobila;
        this.tipGoriva = tipGoriva;
        this.tipMjenjaca = tipMjenjaca;
        this.klasaAutomobila = klasaAutomobila;
        this.imaAndroid = imaAndroid;
        this.coliisionDamageWavier = coliisionDamageWavier;
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

    public MarkaAutomobilaDTO getMarkaAutomobila() {
        return markaAutomobila;
    }

    public void setMarkaAutomobila(MarkaAutomobilaDTO markaAutomobila) {
        this.markaAutomobila = markaAutomobila;
    }

    public VrstaGorivaDTO getTipGoriva() {
        return tipGoriva;
    }

    public void setTipGoriva(VrstaGorivaDTO tipGoriva) {
        this.tipGoriva = tipGoriva;
    }

    public TipMjenjacaDTO getTipMjenjaca() {
        return tipMjenjaca;
    }

    public void setTipMjenjaca(TipMjenjacaDTO tipMjenjaca) {
        this.tipMjenjaca = tipMjenjaca;
    }

    public KlasaAutomobilaDTO getKlasaAutomobila() {
        return klasaAutomobila;
    }

    public void setKlasaAutomobila(KlasaAutomobilaDTO klasaAutomobila) {
        this.klasaAutomobila = klasaAutomobila;
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
}
