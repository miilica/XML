package com.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VoziloInfoDTO {
    private Long id;
    private double cijena;
    private double kilometraza;
    private double mozePreciKM;
    private int brSjedistaZaDjecu;
    private double ocjena;
    private MarkaAutomobilaDTO markaAutomobila;
    private VrstaGorivaDTO tipGoriva;
    private TipMjenjacaDTO tipMjenjaca;
    private KlasaAutomobilaDTO klasaAutomobila;
    private Boolean imaAndroid;
    private boolean coliisionDamageWavier;
}
