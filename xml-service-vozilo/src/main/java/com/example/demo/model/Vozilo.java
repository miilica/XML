package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

//@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Vozilo {

    //@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@Column
    private double cijena;

    //@Column
    private double kilometraza;

    //@Column
    private double mozePreciKM;

    //@Column
    private int brSjedistazaDjecu;

    //@Column
    private double ocjena;

    //@Column
    private MarkaAutomobila markaAutomobila;

    private VrstaGoriva vrstaGoriva;

    private  TipMjenjaca tipMjenjaca;

    private KlasaAutomobila klasaAutomobila;

    private Boolean imaAndroid;

    //@Column
    private boolean coliisionDamageWavier;

    private Set<TerminIznajmljivanja> terminiIznajmljivanja;
    private List<Komentar> komentari;
    //private List<Izvjestaj> izvjestaji;
}
