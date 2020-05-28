package com.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Set;

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
    private MarkaAutomobila markaAutomobila;

    private VrstaGoriva vrstaGoriva;

    private TipMjenjaca tipMjenjaca;

    private KlasaAutomobila klasaAutomobila;

    private Boolean imaAndroid;

    @Column
    private boolean coliisionDamageWavier;

    private Set<TerminIznajmljivanja> terminiIznajmljivanja;
    private Set<Komentar> komentari;
    private Set<Izvjestaj> izvjestaji;
}
