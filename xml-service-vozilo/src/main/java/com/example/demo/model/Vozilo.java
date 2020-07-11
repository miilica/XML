package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
@Getter
@Setter
@Table(name = "vozilo")
public class Vozilo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private double cijena;

    @Column
    private double kilometraza;

    @Column
    private double mozePreciKM;

    @Column
    private int brSjedistaZaDjecu;

    @Column
    private double ocjena;


    @ManyToOne(fetch = FetchType.LAZY)
    private MarkaAutomobila markaAutomobila;


    @ManyToOne( fetch = FetchType.LAZY)
    private TipGoriva tipGoriva;


    @ManyToOne( fetch = FetchType.LAZY)
    private TipMjenjaca tipMjenjaca;


    @ManyToOne(fetch = FetchType.LAZY)
    private KlasaAutomobila klasaAutomobila;

    @Column
    private Boolean imaAndroid;

    @Column
    private boolean coliisionDamageWavier;


    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "ocjene_id")
    private Set<Ocena> ocjene = new HashSet<>();


    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "termini_iznajmljivanja_id")
    private Set<TerminIznajmljivanja> terminiIznajmljivanja;


    @OneToMany(cascade = CascadeType.ALL)
    private Set<Komentar> komentari;

    @OneToMany(mappedBy = "vozilo", fetch = FetchType.LAZY)
    private Set<Izvjestaj> izvjestaji;


    @OneToMany(mappedBy = "vozilo", fetch = FetchType.LAZY)
    private Set<Oglas> oglasi;

    @ManyToOne()
    @JoinColumn(name = "agent_id")
    private Agent agent;

    @OneToMany(mappedBy = "vozilo", cascade = CascadeType.ALL)
    private Set<Slika> slike;


    @OneToMany(mappedBy = "vozilo")
    private Set<Zauzece> zauzece;

    public Vozilo() {
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

    public MarkaAutomobila getMarkaAutomobila() {
        return markaAutomobila;
    }

    public void setMarkaAutomobila(MarkaAutomobila markaAutomobila) {
        this.markaAutomobila = markaAutomobila;
    }

    public TipGoriva getTipGoriva() {
        return tipGoriva;
    }

    public void setTipGoriva(TipGoriva tipGoriva) {
        this.tipGoriva = tipGoriva;
    }

    public TipMjenjaca getTipMjenjaca() {
        return tipMjenjaca;
    }

    public void setTipMjenjaca(TipMjenjaca tipMjenjaca) {
        this.tipMjenjaca = tipMjenjaca;
    }

    public KlasaAutomobila getKlasaAutomobila() {
        return klasaAutomobila;
    }

    public void setKlasaAutomobila(KlasaAutomobila klasaAutomobila) {
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

    public Agent getAgent() {
        return agent;
    }

    public Set<Ocena> getOcjene() {
        return ocjene;
    }

    public void setOcjene(Set<Ocena> ocjene) {
        this.ocjene = ocjene;
    }

    public Set<TerminIznajmljivanja> getTerminiIznajmljivanja() {
        return terminiIznajmljivanja;
    }

    public void setTerminiIznajmljivanja(Set<TerminIznajmljivanja> terminiIznajmljivanja) {
        this.terminiIznajmljivanja = terminiIznajmljivanja;
    }

    public Set<Komentar> getKomentari() {
        return komentari;
    }

    public void setKomentari(Set<Komentar> komentari) {
        this.komentari = komentari;
    }

    public Set<Izvjestaj> getIzvjestaji() {
        return izvjestaji;
    }

    public void setIzvjestaji(Set<Izvjestaj> izvjestaji) {
        this.izvjestaji = izvjestaji;
    }

    public Set<Oglas> getOglasi() {
        return oglasi;
    }

    public void setOglasi(Set<Oglas> oglasi) {
        this.oglasi = oglasi;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }

    public Set<Slika> getSlike() {
        return slike;
    }

    public void setSlike(Set<Slika> slike) {
        this.slike = slike;
    }
}
