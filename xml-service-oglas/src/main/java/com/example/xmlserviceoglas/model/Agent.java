package com.example.xmlserviceoglas.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Agent{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String ime;

    @Column
    private String prezime;

    @Column
    private String adresa;

    @Column
    private String imeKompanije;

    @Column
    private String poslovniMB;

    @Column
    private int brOglasa;

    @OneToMany(mappedBy = "agent", fetch = FetchType.LAZY)
    private Set<Vozilo> vozila;

    @OneToMany(mappedBy = "agent", fetch = FetchType.LAZY)
    private Set<Zahtjev> pristigliZahtjevi;

}
