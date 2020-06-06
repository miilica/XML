package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PretragaDTO {

    private Long id;

    private Date od;

    private Date doo;

    private String modelVozila;

    private MarkaAutomobilaDTO markaAutomobila;

    private KlasaAutomobilaDTO klasaAutomobila;

    private VrstaGorivaDTO gorivo;

    private TipMjenjacaDTO tipMjenjaca;

    private double kilometrazaOd;

    private double mozePreciKM;

    private double kilometrazaDo;

    private String mjestoPreuzimanja;

    private int brSjedistaZaDjecu;

    private double cijenaOd;

    private double cijenaDo;


}