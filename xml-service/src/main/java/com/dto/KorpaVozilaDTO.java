package com.dto;

import com.model.KlasaAutomobila;
import com.model.KorpaVozila;
import com.model.MarkaAutomobila;
import com.model.Vozilo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class KorpaVozilaDTO {

    private Long id;

    private String cijena;

    private String kilometraza;

    private String mozePreciKM;

    private String brSjedistaZaDjecu;

    private String ocjena;

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

    public KorpaVozilaDTO(KorpaVozila v) {
        this.id = v.getId();
        this.cijena = v.getCjena();
        this.kilometraza = v.getKilometraza();
        this.mozePreciKM = v.getMozePreciKM();
    }

}
