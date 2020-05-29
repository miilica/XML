package com.example.demo.dto;

import com.example.demo.model.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VoziloDTO {

    private Long id;
    private double kilomtetraza;
    private double cijena;
    private double ocjena;
    private MarkaAutomobila markaAutomobila;
    private VrstaGoriva gorivo;
    private double mozePreciKM;
    private int brSjedistazaDjecu;
    private TipMjenjaca tipMjenjaca;
    private Boolean imaAndroid;
    private KlasaAutomobila klasaAutomobila;



}
