package com.model;

import com.dto.KlasaAutomobilaDTO;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="klasaautomobila")
public class KlasaAutomobila {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String naziv;

    @OneToMany(mappedBy = "klasaAutomobila", fetch = FetchType.LAZY)
    private Set<Vozilo> vozila;

    public KlasaAutomobila(KlasaAutomobilaDTO k) {
        this.setNaziv(k.getNaziv());
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
