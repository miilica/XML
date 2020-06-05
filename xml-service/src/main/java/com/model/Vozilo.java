package com.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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
/*
    @Column
    private VrstaGoriva vrstaGoriva;


    private TipGoriva tipGoriva;


    @Column
    private TipMjenjaca tipMjenjaca;
*/

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

}
