package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Agent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String ime;

    @Column
    private String prezime;

    @Column
    private String adresa;

    @Column
    private String imeKompanije;

    @Column
    private String poslovniMB;

    @Column
    private int brOglasa;

    @JsonIgnore//uleti u neku beskonacnu petlju kad uzimam sve oglase pa sam morao ovo
    @OneToMany(mappedBy = "agent", fetch = FetchType.LAZY)
    private Set<Vozilo> vozila;


    //private Set<Oglas> oglasi;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getImeKompanije() {
        return imeKompanije;
    }

    public void setImeKompanije(String imeKompanije) {
        this.imeKompanije = imeKompanije;
    }

    public String getPoslovniMB() {
        return poslovniMB;
    }

    public void setPoslovniMB(String poslovniMB) {
        this.poslovniMB = poslovniMB;
    }

    public int getBrOglasa() {
        return brOglasa;
    }

    public void setBrOglasa(int brOglasa) {
        this.brOglasa = brOglasa;
    }

    public Set<Vozilo> getVozila() {
        return vozila;
    }

    public void setVozila(Set<Vozilo> vozila) {
        this.vozila = vozila;
    }
}
