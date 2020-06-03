package com.dto;

public class KlasaAutomobilaDTO {
    private String naziv;

    public KlasaAutomobilaDTO() {
    }

    public KlasaAutomobilaDTO(String naziv) {
        this.naziv = naziv;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }
}
