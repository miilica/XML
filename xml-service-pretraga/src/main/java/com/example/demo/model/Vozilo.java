package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
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
    private boolean imaAndroid;

    @Column
    private boolean coliisionDamageWavier;

    @ManyToOne(fetch = FetchType.LAZY)
    private MarkaAutomobila markaAutomobila;

    @ManyToOne(fetch = FetchType.LAZY)
    private TipGoriva tipGoriva;

    @ManyToOne(fetch = FetchType.LAZY)
    private TipMjenjaca tipMjenjaca;

    @ManyToOne(fetch = FetchType.LAZY)
    private KlasaAutomobila klasaAutomobila;

    @OneToMany(mappedBy = "vozilo", fetch = FetchType.LAZY)
    private Set<TerminIznajmljivanja> terminiIznajmljivanja;

    @OneToMany(mappedBy = "vozilo", fetch = FetchType.LAZY)
    private Set<Oglas> oglasi;
}
