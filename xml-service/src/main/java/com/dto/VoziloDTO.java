package com.dto;

import com.model.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class VoziloDTO {

    private Long id;

    private double cijena;

    private double kilometraza;

    private double mozePreciKM;

    private int brSjedistaZaDjecu;

    private double ocjena;

    private MarkaAutomobila markaAutomobila;

    private KlasaAutomobila klasaAutomobila;

    private Boolean imaAndroid;

    private boolean coliisionDamageWavier;
/*
    private Set<TerminIznajmljivanja> terminiIznajmljivanja;

    private Set<Komentar> komentari;

    private Set<Izvjestaj> izvjestaji;

    private Set<Oglas> oglasi;
*/

    public VoziloDTO(Vozilo v) {
        this.id = v.getId();
        this.cijena = v.getCijena();
        this.brSjedistaZaDjecu = v.getBrSjedistaZaDjecu();
        this.kilometraza = v.getKilometraza();
    }

}
