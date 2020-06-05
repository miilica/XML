package com.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Komentar {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String tekst;

    @Column
    private boolean odobren;

    @ManyToOne(fetch = FetchType.LAZY)
    private Vozilo vozilo;


   // private Agent agent;
   // private Korisnik korisnik;
}
