package com.microservices.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Agent{
    private String ime;
    private String prezime;
    private String adresa;
    private String imeKompanije;
    private String poslovniMB;
    private Set<Vozilo> vozila;
    //private List<Integer> oglasi;
    //private int brOglasa;
    //private List<Integer> pristigliZahtjevi;
}
