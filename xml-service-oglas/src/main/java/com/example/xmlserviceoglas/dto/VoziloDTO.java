package com.example.xmlserviceoglas.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VoziloDTO {
    private Long id;
    private double cijena;
    private double kilometraza;
    private double mozePreciKM;
    private int brSjedistaZaDjecu;
    private double ocjena;
    private boolean imaAndroid;
    private boolean coliisionDamageWavier;
    private MarkaAutomobilaDTO markaAutomobila;
    private VrstaGorivaDTO tipGoriva;
    private TipMjenjacaDTO tipMjenjaca;
    private KlasaAutomobilaDTO klasaAutomobila;
    private Set<KomentarDTO> komentari;
    private AgentDTO agent;
    private Set<IzvjestajDTO> izvjestaji;
}
