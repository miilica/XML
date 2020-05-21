package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Pretraga {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Date od;

    @Column
    private Date doo;

    @Column
    private String modelVozila;

    @Column
    private String klasaVozila;

    @Column
    private double kilometraza;

    @Column
    private int cijena;

    @Column
    private double ocjena;

    @Column
    private VrstaGoriva gorivo;

    @Column
    private TipMjenjanca mjenjac;

    @Column
    private String imeKompanije;

    public Long getId() {
        return id;
    }

    public Date getOd() {
        return od;
    }

    public Date getDoo() {
        return doo;
    }

    public String getModelVozila() {
        return modelVozila;
    }

    public String getKlasaVozila() {
        return klasaVozila;
    }

    public double getKilometraza() {
        return kilometraza;
    }

    public int getCijena() {
        return cijena;
    }

    public double getOcjena() {
        return ocjena;
    }

    public VrstaGoriva getGorivo() {
        return gorivo;
    }

    public TipMjenjanca getMjenjac() {
        return mjenjac;
    }

    public String getImeKompanije() {
        return imeKompanije;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setOd(Date od) {
        this.od = od;
    }

    public void setDoo(Date doo) {
        this.doo = doo;
    }

    public void setModelVozila(String modelVozila) {
        this.modelVozila = modelVozila;
    }

    public void setKlasaVozila(String klasaVozila) {
        this.klasaVozila = klasaVozila;
    }

    public void setKilometraza(double kilometraza) {
        this.kilometraza = kilometraza;
    }

    public void setCijena(int cijena) {
        this.cijena = cijena;
    }

    public void setOcjena(double ocjena) {
        this.ocjena = ocjena;
    }

    public void setGorivo(VrstaGoriva gorivo) {
        this.gorivo = gorivo;
    }

    public void setMjenjac(TipMjenjanca mjenjac) {
        this.mjenjac = mjenjac;
    }

    public void setImeKompanije(String imeKompanije) {
        this.imeKompanije = imeKompanije;
    }
}
