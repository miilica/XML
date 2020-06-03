package com.model;

import javax.persistence.*;

@Entity
@Table(name="klasaautomobila")
public class KlasaAutomobila {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String naziv;

    public KlasaAutomobila(String naziv) {
        this.naziv = naziv;
    }

    public KlasaAutomobila() {
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }
}
