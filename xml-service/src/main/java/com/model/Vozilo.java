package com.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.dto.VoziloDTO;

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

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "ocjene_id")
    private Set<Ocena> ocjene = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    private MarkaAutomobila markaAutomobila;
/*
    @Column
    private VrstaGoriva vrstaGoriva;

*/
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

    @OneToMany(mappedBy = "vozilo", fetch = FetchType.LAZY)
    private Set<TerminIznajmljivanja> terminiIznajmljivanja;

    @OneToMany(mappedBy = "vozilo", fetch = FetchType.LAZY)
    private Set<Komentar> komentari;

    @OneToMany(mappedBy = "vozilo", fetch = FetchType.LAZY)
    private Set<Izvjestaj> izvjestaji;

    @OneToMany(mappedBy = "vozilo", fetch = FetchType.EAGER)
    private Set<Oglas> oglasi;

    @ManyToOne()
    @JoinColumn(name = "agent_id")
    private Agent agent;

   // private Set<TerminIznajmljivanja> terminiIznajmljivanja;
   // private Set<Komentar> komentari;
  //  private Set<Izvjestaj> izvjestaji;


    public Vozilo() {
    }

    public Vozilo(VoziloDTO vDTO){
        this.setId(vDTO.getId());
        this.setCijena(vDTO.getCijena());
        this.setKilometraza(vDTO.getKilometraza());
        this.setMozePreciKM(vDTO.getMozePreciKM());
        this.setBrSjedistaZaDjecu(vDTO.getBrSjedistaZaDjecu());
        this.setOcjena(vDTO.getOcjena());
        //this.setMarkaAutomobila(new MarkaAutomobila(vDTO.getMarkaAutomobila()));
        //this.setKlasaAutomobila(new KlasaAutomobila(vDTO.getKlasaAutomobila()));
        //this.setTipGoriva(new TipGoriva(vDTO.getTipGoriva()));
        //this.setTipMjenjaca(new TipMjenjaca(vDTO.getTipMjenjaca()));
        this.setImaAndroid(vDTO.getImaAndroid());
        this.setColiisionDamageWavier(vDTO.isColiisionDamageWavier());

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

}
