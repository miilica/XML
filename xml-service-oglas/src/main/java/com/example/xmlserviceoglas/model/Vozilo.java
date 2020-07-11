package com.example.xmlserviceoglas.model;

import com.example.xmlserviceoglas.dto.VoziloDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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

    @Column
    private Boolean imaAndroid;

    @Column
    private boolean coliisionDamageWavier;

    @ManyToOne(fetch = FetchType.LAZY)
    private KlasaAutomobila klasaAutomobila;

    @ManyToOne( fetch = FetchType.LAZY)
    private TipGoriva tipGoriva;

    @ManyToOne( fetch = FetchType.LAZY)
    private TipMjenjaca tipMjenjaca;

    @ManyToOne(fetch = FetchType.LAZY)
    private MarkaAutomobila markaAutomobila;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Komentar> komentari;

    @ManyToOne()
    @JoinColumn(name = "agent_id")
    private Agent agent;

    @OneToMany(mappedBy = "vozilo", fetch = FetchType.LAZY)
    private Set<Izvjestaj> izvjestaji;

    @OneToMany(mappedBy = "vozilo")
    private Set<Zauzece> zauzece;

    @OneToMany(mappedBy = "vozilo", fetch = FetchType.LAZY)
    private Set<Oglas> oglasi;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "ocjene_id")
    private Set<Ocena> ocjene = new HashSet<>();


    public Vozilo(VoziloDTO v){
        this.id = v.getId();
        this.cijena = v.getCijena();
        this.kilometraza = v.getKilometraza();
        this.mozePreciKM = v.getMozePreciKM();
        this.brSjedistaZaDjecu = v.getBrSjedistaZaDjecu();
        this.ocjena = v.getOcjena();
        this.coliisionDamageWavier = v.isColiisionDamageWavier();
        this.imaAndroid = v.isImaAndroid();
    }
}
