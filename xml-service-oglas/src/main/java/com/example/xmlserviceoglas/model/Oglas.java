package com.example.xmlserviceoglas.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Oglas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //private Vozilo vozilo;

    @Column
    private boolean dostupan;

    @Column
    private String mjestoPreuzimanja;
    //private TerminIznajmljivanja terminIznajmljivanja;
    //private Cjenovnik cjenovnik;

}
